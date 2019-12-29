package com.transaction;

import java.io.Serializable;

/**
 * Created by Brian in 14:54 2018/11/4
 */
public class BookStockException extends RuntimeException {
    private static final long serialVersionUID = 1088387486781068496L;

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
