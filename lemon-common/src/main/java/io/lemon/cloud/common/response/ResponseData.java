package io.lemon.cloud.common.response;

import lombok.Data;

@Data
public class ResponseData {

    private int code = 200;

    private String message;

    private String requestId;

    private Object data;

    public static ResponseData fail(ResponseEnum responseEnum) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(responseEnum.getCode());
        responseData.setMessage(responseEnum.getMessage());
        return responseData;
    }

}
