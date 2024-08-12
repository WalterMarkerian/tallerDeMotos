package com.tallerDeMotos.motocicleta.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletasNotFoundException extends BaseException {

    private static final long serialVersionUID = 1234567891L; // Cambia el valor según sea necesario
    public static final String DEFAULT_ERROR_CODE = "ERR_MOTOCICLETAS_NOT_FOUND";
    public static final String DEFAULT_ERROR_MESSAGE = "No motorcycles found.";

    public MotocicletasNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public MotocicletasNotFoundException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.code = DEFAULT_ERROR_CODE;
    }
}
