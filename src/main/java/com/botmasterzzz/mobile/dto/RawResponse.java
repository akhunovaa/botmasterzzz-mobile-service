package com.botmasterzzz.mobile.dto;

import com.botmasterzzz.mobile.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawResponse extends Response{

    @JsonRawValue
    private Object response;

    public RawResponse() {
        this(true, null, null);
    }

    public RawResponse(CustomException exception) {
        this(false, exception.getMessage(), null);
    }

    public RawResponse(Object response) {
        this(true, null, response);
        this.response = response;
    }

    public RawResponse(Boolean success, String errorMessage, Object response) {
        super(success, errorMessage, response);
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

}
