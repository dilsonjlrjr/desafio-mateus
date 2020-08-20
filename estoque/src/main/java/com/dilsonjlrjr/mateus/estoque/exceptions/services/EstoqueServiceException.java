package com.dilsonjlrjr.mateus.estoque.exceptions.services;

public class EstoqueServiceException extends Exception {
    public EstoqueServiceException() {
        super();
    }

    public EstoqueServiceException(String message) {
        super(message);
    }

    public EstoqueServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EstoqueServiceException(Throwable cause) {
        super(cause);
    }

    protected EstoqueServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
