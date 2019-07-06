package org.nix.home.pojo.dto;

import lombok.Data;

@Data
public class ResponseDto<T> {

    private static final Integer AUTHENTICATION_FAIL = 403;

    private static final Integer SERVICE_ERROR = 500;

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public ResponseDto(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static ResponseDto authenticationFailure() {
        return new ResponseDto(false, SERVICE_ERROR, "账号认证失败");
    }

    public static ResponseDto permissionFailure(){
        return new ResponseDto(false, AUTHENTICATION_FAIL, "权限异常");
    }

}
