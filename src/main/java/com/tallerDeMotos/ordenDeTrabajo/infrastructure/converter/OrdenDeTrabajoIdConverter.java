package com.tallerDeMotos.ordenDeTrabajo.infrastructure.converter;

import com.tallerDeMotos.commons.infrastructure.converter.AbstractIdConverter;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrdenDeTrabajoIdConverter extends AbstractIdConverter<OrdenDeTrabajoId> {

    @Override
    protected Long getIdValue(OrdenDeTrabajoId id) {
        return id.getId();
    }

    @Override
    protected OrdenDeTrabajoId createId(Long idValue) {
        return new OrdenDeTrabajoId(idValue);
    }
}
