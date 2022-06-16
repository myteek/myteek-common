package com.myteek.common;

import lombok.Getter;

@Getter
public class ResponseStatus {

    /**
     * common
     */
    public static final ResponseStatus SUCCESS =
            ResponseStatus.builder().code(0).message("成功").build();

    public static final ResponseStatus ERROR =
            ResponseStatus.builder().code(1).message("错误").build();

    public static final ResponseStatus DATA_READ_WRITE_ERROR =
            ResponseStatus.builder().code(2).message("数据读写错误").build();

    public static final ResponseStatus PARAM_ERROR =
            ResponseStatus.builder().code(10).message("参数错误").build();

    public static final ResponseStatus PARAM_TYPE_MISMATCH =
            ResponseStatus.builder().code(11).message("参数类型不匹配").build();

    public static final ResponseStatus TOKEN_ERROR =
            ResponseStatus.builder().code(12).message("令牌错误").build();

    public static final ResponseStatus TOKEN_EXPIRED =
            ResponseStatus.builder().code(13).message("令牌已过期").build();

    public static final ResponseStatus API_PERMISSION_ERROR =
            ResponseStatus.builder().code(14).message("接口权限错误").build();

    public static final ResponseStatus DATA_EXISTS_ERROR =
            ResponseStatus.builder().code(20).message("数据不存在").build();

    public static final ResponseStatus DATA_READ_ERROR =
            ResponseStatus.builder().code(21).message("数据读取错误").build();

    public static final ResponseStatus DATA_WRITE_ERROR =
            ResponseStatus.builder().code(22).message("数据写入错误").build();

    public static final ResponseStatus DATA_ADD_ERROR =
            ResponseStatus.builder().code(23).message("数据添加错误").build();

    public static final ResponseStatus DATA_EDIT_ERROR =
            ResponseStatus.builder().code(24).message("数据编辑错误").build();

    public static final ResponseStatus DATA_DELETE_ERROR =
            ResponseStatus.builder().code(25).message("数据删除错误").build();

    /**
     * 1xx message
     */
    public static final ResponseStatus HTTP_CONTINUE =
            ResponseStatus.builder().code(2100).message("HTTP_CONTINUE").build();

    public static final ResponseStatus HTTP_SWITCHING_PROTOCOLS =
            ResponseStatus.builder().code(2101).message("HTTP_SWITCHING_PROTOCOLS").build();

    public static final ResponseStatus HTTP_PROCESSING =
            ResponseStatus.builder().code(2102).message("HTTP_PROCESSING").build();

    public static final ResponseStatus HTTP_EARLY_HINTS =
            ResponseStatus.builder().code(2103).message("HTTP_EARLY_HINTS").build();

    /**
     * 2xx success
     */
    public static final ResponseStatus HTTP_OK =
            ResponseStatus.builder().code(2200).message("HTTP_OK").build();

    public static final ResponseStatus HTTP_CREATED =
            ResponseStatus.builder().code(2201).message("HTTP_CREATED").build();

    public static final ResponseStatus HTTP_ACCEPTED =
            ResponseStatus.builder().code(2202).message("HTTP_ACCEPTED").build();

    public static final ResponseStatus HTTP_NON_AUTHORITATIVE_INFORMATION =
            ResponseStatus.builder().code(2203).message("HTTP_NON_AUTHORITATIVE_INFORMATION").build();

    public static final ResponseStatus HTTP_NO_CONTENT =
            ResponseStatus.builder().code(2204).message("HTTP_NO_CONTENT").build();

    public static final ResponseStatus HTTP_RESET_CONTENT =
            ResponseStatus.builder().code(2205).message("HTTP_RESET_CONTENT").build();

    public static final ResponseStatus HTTP_PARTIAL_CONTENT =
            ResponseStatus.builder().code(2206).message("HTTP_PARTIAL_CONTENT").build();

    public static final ResponseStatus HTTP_MULTI_STATUS =
            ResponseStatus.builder().code(2207).message("HTTP_MULTI_STATUS").build();

    public static final ResponseStatus HTTP_ALREADY_REPORTED =
            ResponseStatus.builder().code(2208).message("HTTP_ALREADY_REPORTED").build();

    public static final ResponseStatus HTTP_IM_USED =
            ResponseStatus.builder().code(2226).message("HTTP_IM_USED").build();

    /**
     * 3xx redirect
     */
    public static final ResponseStatus HTTP_MULTIPLE_CHOICES =
            ResponseStatus.builder().code(2300).message("HTTP_MULTIPLE_CHOICE").build();

    public static final ResponseStatus HTTP_MOVED_PERMANENTLY =
            ResponseStatus.builder().code(2301).message("HTTP_MOVED_PERMANENTLY").build();

    public static final ResponseStatus HTTP_FOUND =
            ResponseStatus.builder().code(2302).message("HTTP_FOUND").build();

    public static final ResponseStatus HTTP_SEE_OTHER =
            ResponseStatus.builder().code(2303).message("HTTP_SEE_OTHER").build();

    public static final ResponseStatus HTTP_NOT_MODIFIED =
            ResponseStatus.builder().code(2304).message("HTTP_NOT_MODIFIED").build();

    public static final ResponseStatus HTTP_USE_PROXY =
            ResponseStatus.builder().code(2305).message("HTTP_USE_PROXY").build();

    public static final ResponseStatus HTTP_SWITCH_PROXY =
            ResponseStatus.builder().code(2306).message("HTTP_SWITCH_PROXY").build();

    public static final ResponseStatus HTTP_TEMPORARY_REDIRECT =
            ResponseStatus.builder().code(2307).message("HTTP_TEMPORARY_REDIRECT").build();

    public static final ResponseStatus HTTP_PERMANENT_REDIRECT =
            ResponseStatus.builder().code(2308).message("HTTP_PERMANENT_REDIRECT").build();

    /**
     * 4xx client error
     */
    public static final ResponseStatus HTTP_BAD_REQUEST =
            ResponseStatus.builder().code(2400).message("HTTP_BAD_REQUEST").build();

    public static final ResponseStatus HTTP_UNAUTHORIZED =
            ResponseStatus.builder().code(2401).message("HTTP_UNAUTHORIZED").build();

    public static final ResponseStatus HTTP_PAYMENT_REQUIRED =
            ResponseStatus.builder().code(2402).message("HTTP_PAYMENT_REQUIRED").build();

    public static final ResponseStatus HTTP_FORBIDDEN =
            ResponseStatus.builder().code(2403).message("HTTP_FORBIDDEN").build();

    public static final ResponseStatus HTTP_NOT_FOUND =
            ResponseStatus.builder().code(2404).message("HTTP_NOT_FOUND").build();

    public static final ResponseStatus HTTP_METHOD_NOT_ALLOWED =
            ResponseStatus.builder().code(2405).message("HTTP_METHOD_NOT_ALLOWED").build();

    public static final ResponseStatus HTTP_NOT_ACCEPTABLE =
            ResponseStatus.builder().code(2406).message("HTTP_NOT_ACCEPTABLE").build();

    public static final ResponseStatus HTTP_PROXY_AUTHENTICATION_REQUIRED =
            ResponseStatus.builder().code(2407).message("HTTP_PROXY_AUTHENTICATION_REQUIRED").build();

    public static final ResponseStatus HTTP_REQUEST_TIMEOUT =
            ResponseStatus.builder().code(2408).message("HTTP_REQUEST_TIMEOUT").build();

    public static final ResponseStatus HTTP_CONFLICT =
            ResponseStatus.builder().code(2409).message("HTTP_CONFLICT").build();

    public static final ResponseStatus HTTP_GONE = ResponseStatus.builder().code(2410).message("HTTP_GONE").build();

    public static final ResponseStatus HTTP_LENGTH_REQUIRED =
            ResponseStatus.builder().code(2411).message("HTTP_LENGTH_REQUIRED").build();

    public static final ResponseStatus HTTP_PRECONDITION_FAILED =
            ResponseStatus.builder().code(2412).message("HTTP_PRECONDITION_FAILED").build();

    public static final ResponseStatus HTTP_REQUEST_ENTITY_TOO_LARGE =
            ResponseStatus.builder().code(2413).message("HTTP_REQUEST_ENTITY_TOO_LARGE").build();

    public static final ResponseStatus HTTP_REQUEST_URI_TOO_LONG =
            ResponseStatus.builder().code(2414).message("HTTP_REQUEST_URI_TOO_LONG").build();

    public static final ResponseStatus HTTP_UNSUPPORTED_MEDIA_TYPE =
            ResponseStatus.builder().code(2415).message("HTTP_UNSUPPORTED_MEDIA_TYPE").build();

    public static final ResponseStatus HTTP_REQUESTED_RANGE_NOT_SATISFIABLE =
            ResponseStatus.builder().code(2416).message("HTTP_REQUESTED_RANGE_NOT_SATISFIABLE").build();

    public static final ResponseStatus HTTP_EXPECTATION_FAILED =
            ResponseStatus.builder().code(2417).message("HTTP_EXPECTATION_FAILED").build();

    public static final ResponseStatus HTTP_I_AM_A_TEAPOT =
            ResponseStatus.builder().code(2418).message("HTTP_I_AM_A_TEAPOT").build();

    public static final ResponseStatus HTTP_MISDIRECTED_REQUEST =
            ResponseStatus.builder().code(2421).message("HTTP_MISDIRECTED_REQUEST").build();

    public static final ResponseStatus HTTP_UNPROCESSABLE_ENTITY =
            ResponseStatus.builder().code(2422).message("HTTP_UNPROCESSABLE_ENTITY").build();

    public static final ResponseStatus HTTP_LOCKED =
            ResponseStatus.builder().code(2423).message("HTTP_LOCKED").build();

    public static final ResponseStatus HTTP_FAILED_DEPENDENCY =
            ResponseStatus.builder().code(2424).message("HTTP_FAILED_DEPENDENCY").build();

    public static final ResponseStatus HTTP_UPGRADE_REQUIRED =
            ResponseStatus.builder().code(2426).message("HTTP_UPGRADE_REQUIRED").build();

    public static final ResponseStatus HTTP_PRECONDITION_REQUIRED =
            ResponseStatus.builder().code(2428).message("HTTP_PRECONDITION_REQUIRED").build();

    public static final ResponseStatus HTTP_TOO_MANY_REQUESTS =
            ResponseStatus.builder().code(2429).message("HTTP_TOO_MANY_REQUESTS").build();

    public static final ResponseStatus HTTP_REQUEST_HEADER_FIELD_TOO_LARGE =
            ResponseStatus.builder().code(2431).message("HTTP_REQUEST_HEADER_FIELD_TOO_LARGE").build();

    public static final ResponseStatus HTTP_LOGIN_TIMEOUT =
            ResponseStatus.builder().code(2440).message("HTTP_LOGIN_TIMEOUT").build();

    public static final ResponseStatus HTTP_UNAVAILABLE =
            ResponseStatus.builder().code(2451).message("HTTP_UNAVAILABLE").build();

    /**
     * 5xx server error
     */
    public static final ResponseStatus HTTP_INTERNAL_SERVER_ERROR =
            ResponseStatus.builder().code(2500).message("HTTP_INTERNAL_SERVER_ERROR").build();

    public static final ResponseStatus HTTP_NOT_IMPLEMENTED =
            ResponseStatus.builder().code(2501).message("HTTP_NOT_IMPLEMENTED").build();

    public static final ResponseStatus HTTP_BAD_GATEWAY =
            ResponseStatus.builder().code(2502).message("HTTP_BAD_GATEWAY").build();

    public static final ResponseStatus HTTP_SERVICE_UNAVAILABLE =
            ResponseStatus.builder().code(2503).message("HTTP_SERVICE_UNAVAILABLE").build();

    public static final ResponseStatus HTTP_GATEWAY_TIMEOUT =
            ResponseStatus.builder().code(2504).message("HTTP_GATEWAY_TIMEOUT").build();

    public static final ResponseStatus HTTP_VERSION_NOT_SUPPORTED =
            ResponseStatus.builder().code(2505).message("HTTP_VERSION_NOT_SUPPORTED").build();

    public static final ResponseStatus HTTP_VARIANT_ALSO_NEGOTIATES =
            ResponseStatus.builder().code(2506).message("HTTP_VARIANT_ALSO_NEGOTIATES").build();

    public static final ResponseStatus HTTP_INSUFFICIENT_STORAGE =
            ResponseStatus.builder().code(2507).message("HTTP_INSUFFICIENT_STORAGE").build();

    public static final ResponseStatus HTTP_LOOP_DETECTED =
            ResponseStatus.builder().code(2508).message("HTTP_LOOP_DETECTED").build();

    public static final ResponseStatus HTTP_NOT_EXTENDED =
            ResponseStatus.builder().code(2510).message("HTTP_NOT_EXTENDED").build();

    public static final ResponseStatus HTTP_NETWORK_AUTHENTICATION_REQUIRED =
            ResponseStatus.builder().code(2511).message("HTTP_NETWORK_AUTHENTICATION_REQUIRED").build();

    /**
     * not official
     */
    public static final ResponseStatus HTTP_ENHANCE_YOUR_CALM =
            ResponseStatus.builder().code(2420).message("HTTP_ENHANCE_YOUR_CALM").build();

    public static final ResponseStatus HTTP_NO_RESPONSE =
            ResponseStatus.builder().code(2444).message("HTTP_NO_RESPONSE").build();

    public static final ResponseStatus HTTP_BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS =
            ResponseStatus.builder().code(2450).message("").build();

    public static final ResponseStatus HTTP_REQUEST_HEADER_TOO_LARGE =
            ResponseStatus.builder().code(2494).message("HTTP_REQUEST_HEADER_TOO_LARGE").build();

    private int code;

    private String message;

    public ResponseStatus(Builder builder) {
        this(builder.code, builder.message);
    }

    public ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int code;

        private String message;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseStatus build() {
            return new ResponseStatus(this);
        }

    }

}
