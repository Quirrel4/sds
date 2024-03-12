package com.he.sds.common.exception;

public class ViewException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ViewException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    public ViewException(String message,Throwable cause){
        super(message,cause);
    }

    public ViewException(String message){
        super(message);
    }

    public ViewException(Throwable cause){
        super(cause);
    }
}
