package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClienteDuplicateDniException extends BaseException {

    private static final long serialVersionUID = 8237342515687888090L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUCPLICATE_DNI";
    public static final String DEFAULT_ERROR_MESSAGE = "The client DNI already exists.";

    public ClienteDuplicateDniException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ClienteDuplicateDniException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.code = DEFAULT_ERROR_CODE;
    }
}
