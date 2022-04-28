package com.myteek.common;

import lombok.Getter;

@Getter
public class HttpResponseException extends RuntimeException {

    private ResponseStatus statusCode;

    public HttpResponseException(ResponseStatus statusCode) {
        this.statusCode = statusCode;
    }

    public HttpResponseException(ResponseStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

}
