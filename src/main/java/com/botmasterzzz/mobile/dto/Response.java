package com.botmasterzzz.mobile.dto;

import com.botmasterzzz.mobile.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    protected static final String TEXTAREA_TMP = "<textarea>{success:%b,errorMessage:'%s'}</textarea>";

    @JsonProperty
    private final Boolean success;
    @JsonProperty
    private final String errorMessage;
    @JsonProperty
    private final Object response;

    public Response() {
        this(true, null, null);
    }

    public Response(CustomException exception) {
        this(false, exception.getMessage(), null);
    }

    public Response(Object response) {
        this(true, null, response);
    }

    public Response(Boolean success, String errorMessage, Object response) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.response = response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object getResponse() {
        return response;
    }

    public String wrapTextareaString() {
        return String.format(TEXTAREA_TMP, this.success, this.errorMessage == null ? "" : this.errorMessage);
    }
}
