package com.storm.luban.exception;

public class UserMaterialException extends BizException {
    public UserMaterialException(String message) {
        super(message);
    }

    public UserMaterialException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserMaterialException(Throwable cause) {
        super(cause);
    }

    public UserMaterialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
