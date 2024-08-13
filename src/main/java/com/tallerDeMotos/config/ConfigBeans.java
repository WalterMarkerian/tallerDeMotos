package com.tallerDeMotos.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ConfigBeans {

    @Bean
    public LocaleResolver localeResolver() {

        SessionLocaleResolver localResolver = new SessionLocaleResolver();
        localResolver.setDefaultLocale(new Locale("es", "AR"));
        return localResolver;
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("messages/errors");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setUseCodeAsDefaultMessage(true);

        return bundleMessageSource;
    }

}
