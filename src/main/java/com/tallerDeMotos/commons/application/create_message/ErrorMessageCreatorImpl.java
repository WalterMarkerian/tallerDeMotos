package com.tallerDeMotos.commons.application.create_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ErrorMessageCreatorImpl implements ErrorMessageCreator {
    @Autowired
    MessageSource messageResource;
    public String getMessage(String code) {
        return messageResource.getMessage(code, null, new Locale("es", "AR"));
    }
}