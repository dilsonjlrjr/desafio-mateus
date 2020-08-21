package com.dilsonjlrjr.mateus.estoque.exceptions.services;

public class ProdutoServiceException extends Exception {
    public ProdutoServiceException() {
        super();
    }

    public ProdutoServiceException(String message) {
        super(message);
    }

    public ProdutoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProdutoServiceException(Throwable cause) {
        super(cause);
    }

    protected ProdutoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
