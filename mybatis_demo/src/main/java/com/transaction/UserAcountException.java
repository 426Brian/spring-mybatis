package com.transaction;

/**
 * Created by Brian in 14:54 2018/11/4
 */
public class UserAcountException extends RuntimeException {


    private static final long serialVersionUID = -326661157362044110L;

    public UserAcountException() {
    }

    public UserAcountException(String message) {
        super(message);
    }

    public UserAcountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAcountException(Throwable cause) {
        super(cause);
    }

    public UserAcountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
