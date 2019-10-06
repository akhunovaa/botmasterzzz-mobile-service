package com.botmasterzzz.mobile.controller;

import com.botmasterzzz.mobile.dto.Feedback;
import com.botmasterzzz.mobile.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@Profile({"local", "dev"})
public class FeedbackController extends AbstractController{

    @Autowired
    @Qualifier("email")
    private Session session;

    @Autowired
    private CaptchaService captchaService;

    @RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Feedback feedback(@NotNull @RequestBody Feedback feedback, HttpServletRequest request) throws MessagingException {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        String response = feedback.getCaptchaToken();
        captchaService.processResponse(response, ipAddress);
        if (null != feedback.getName() && null != feedback.getPhone() && null != feedback.getMessage()) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("feedback@botmasterzzz.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("feedback@botmasterzzz.com"));
            if (feedback.getName().length() <= 30) {
                message.setSubject("Mail from " + feedback.getName());
            } else {
                message.setSubject("Mail from feedback");
            }
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("<b>Name</b>: ").append(feedback.getName()).append("<br/>");
            messageBuilder.append("<b>Phone</b>: ").append(feedback.getPhone()).append("<br/>");
            messageBuilder.append("<b>e-mail</b>: ").append(feedback.getEmail()).append("<br/>");
            messageBuilder.append("<br/>");
            messageBuilder.append("<b>Message</b>: ").append(feedback.getMessage()).append("<br/>");

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(messageBuilder.toString(), "text/html; charset=UTF-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        }
        return feedback;
    }
}
