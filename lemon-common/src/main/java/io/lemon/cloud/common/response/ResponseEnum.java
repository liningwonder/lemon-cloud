package io.lemon.cloud.common.response;

public enum ResponseEnum {
    SC_OK(200, "OK"),
    SC_FAIL(400, "FAIL"),
    SC_INTERNAL_SERVER_ERROR(500,"SERVER ERROR"),
    SC_FORBIDDEN_IP(403, "非法IP请求");


    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
