package com.botmasterzzz.mobile.service;

public interface ReCaptchaAttemptService {

    void reCaptchaSucceeded(String key);

    void reCaptchaFailed(String key);

    boolean isBlocked(String key);
}
