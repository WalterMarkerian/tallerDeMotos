package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClienteNotFoundException extends BaseException {

    private static final long serialVersionUID = 8237342515687888090L;
    public static final String DEFAULT_ERROR_CODE = "ERR_CLIENT_NOT_FOUND";
    public static final String DEFAULT_ERROR_MESSAGE = "Client not found.";

    public ClienteNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ClienteNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.code = DEFAULT_ERROR_CODE;
    }
}
