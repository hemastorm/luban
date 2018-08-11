package com.storm.luban.exception;

public class SysDataException extends BizException {
    public SysDataException(String message) {
        super(message);
    }

    public SysDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysDataException(Throwable cause) {
        super(cause);
    }

    public SysDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
