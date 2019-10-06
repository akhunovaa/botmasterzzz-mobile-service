package com.botmasterzzz.mobile.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Feedback {

    @NotBlank(message="Имя должно быть задано")
    @Size(min = 3, max = 300, message="Длина имени не соответствует правилам")
    private String name;

    @Size(max = 300, message="Длина email'a не соответствует правилам")
    private String email;

    @NotBlank(message="Номер телефона должен быть задан")
    @Size(max = 300, message="Длина номера телефона не соответствует правилам")
    private String phone;

    @Size(min = 3, max = 3000, message="Длина сообщения не соответствует правилам")
    private String message;

    private String captchaToken;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCaptchaToken() {
        return captchaToken;
    }

    public void setCaptchaToken(String captchaToken) {
        this.captchaToken = captchaToken;
    }
}
