package com.tallerDeMotos.commons.infrastructure.converter;

import jakarta.persistence.AttributeConverter;

public abstract class AbstractIdConverter<T> implements AttributeConverter<T, Long> {

    @Override
    public Long convertToDatabaseColumn(T attribute) {
        return attribute != null ? getIdValue(attribute) : null;
    }

    @Override
    public T convertToEntityAttribute(Long dbData) {
        return dbData != null ? createId(dbData) : null;
    }

    protected abstract Long getIdValue(T id);

    protected abstract T createId(Long idValue);
}
