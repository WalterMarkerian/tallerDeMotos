package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClientesNotFoundException extends BaseException {

    private static final long serialVersionUID = 1234567890L; // Cambia el valor según sea necesario
    public static final String DEFAULT_ERROR_CODE = "ERR_CLIENTES_NOT_FOUND";
    public static final String DEFAULT_ERROR_MESSAGE = "No clients found.";

    public ClientesNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ClientesNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.code = DEFAULT_ERROR_CODE;
    }
}
