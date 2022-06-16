package com.myteek.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public final class Response<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    /**
     * constructor
     * @param code response code
     * @param message response message
     * @param data response data object
     */
    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response of(int code, String message) {
        return new Response(code, message, null);
    }

    public static Response of(ResponseStatus codeStatus) {
        return of(codeStatus, null);
    }

    public static <T> Response of(ResponseStatus codeStatus, T data) {
        return new Response(codeStatus.getCode(), codeStatus.getMessage(), data);
    }

    public static Response of(boolean status) {
        return status ? success(null) : error(null);
    }

    public static <T> Response success(T value) {
        return of(ResponseStatus.SUCCESS, value);
    }

    public static <T> Response error(T value) {
        return of(ResponseStatus.ERROR, value);
    }

    private Response(Builder<T> builder) {
        this(builder.code, builder.message, builder.data);
    }

    public static class Builder<T> {

        private int code;

        private String message;

        private T data;

        public Builder(int code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * init builder
         * @param code code
         * @param message message
         * @param data data
         */
        public Builder(int code, String message, T data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder date(T data) {
            this.data = data;
            return this;
        }

        public Response builder() {
            return new Response(this);
        }
    }

}
