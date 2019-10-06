package com.botmasterzzz.mobile.service.impl;

import com.botmasterzzz.mobile.dto.GoogleResponse;
import com.botmasterzzz.mobile.exception.InvalidReCaptchaException;
import com.botmasterzzz.mobile.service.CaptchaService;
import com.botmasterzzz.mobile.service.ReCaptchaAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.regex.Pattern;

@Service
@Profile({"local", "dev"})
public class CaptchaServiceImplementation implements CaptchaService {

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    @Value("${google.recaptcha.key.site}")
    private String secretSiteKey;

    @Value("${google.recaptcha.key.secret}")
    private String secretKeySecret;

    @Autowired
    @Qualifier("restTemplate")
    private RestOperations restTemplate;

    @Autowired
    private ReCaptchaAttemptService reCaptchaAttemptService;


    @Override
    public void processResponse(String response, String clientIp) {
        if(!responseSanityCheck(response)) {
            throw new InvalidReCaptchaException("Response contains invalid characters");
        }

        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
                secretKeySecret, response, clientIp));

        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);

        if(!googleResponse.isSuccess()) {
            if(googleResponse.hasClientError()) {
                reCaptchaAttemptService.reCaptchaFailed(clientIp);
            }
            throw new InvalidReCaptchaException("reCaptcha was not successfully validated");
        }
        reCaptchaAttemptService.reCaptchaSucceeded(clientIp);
    }

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }
}
