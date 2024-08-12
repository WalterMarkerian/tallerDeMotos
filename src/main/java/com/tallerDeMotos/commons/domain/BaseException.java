package com.tallerDeMotos.commons.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends Exception {

    private static final long serialVersionUID = -2548108658527544758L;

    public String code;
    public String message;

    public BaseException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }
}
