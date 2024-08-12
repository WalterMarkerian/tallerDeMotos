package com.tallerDeMotos.motocicleta.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletaDuplicatePatenteException extends BaseException {

    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DOMAIN";
    public static final String DEFAULT_ERROR_MESSAGE = "Domain already exists.";

    public MotocicletaDuplicatePatenteException(String code, String message) {
        super(message);
        this.code = code;
    }

    public MotocicletaDuplicatePatenteException() {
        super(DEFAULT_ERROR_MESSAGE);
        this.code = DEFAULT_ERROR_CODE;
    }

}
