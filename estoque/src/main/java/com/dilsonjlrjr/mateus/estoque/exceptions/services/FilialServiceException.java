package com.dilsonjlrjr.mateus.estoque.exceptions.services;

public class FilialServiceException extends Exception {
    public FilialServiceException() {
    }

    public FilialServiceException(String message) {
        super(message);
    }

    public FilialServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilialServiceException(Throwable cause) {
        super(cause);
    }

    public FilialServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
