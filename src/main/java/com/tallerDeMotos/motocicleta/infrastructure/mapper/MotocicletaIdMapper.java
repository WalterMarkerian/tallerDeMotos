package com.tallerDeMotos.motocicleta.infrastructure.mapper;

import com.tallerDeMotos.motocicleta.domain.MotocicletaId;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper(componentModel = "spring")
@Qualifier("motocicletaIdMapper")
public interface MotocicletaIdMapper {

    // Convierte MotocicletaId a Long
    default Long map(MotocicletaId motocicletaId) {
        return motocicletaId != null ? motocicletaId.getId() : null;
    }

    // Convierte Long a MotocicletaId
    default MotocicletaId map(Long id) {
        return id != null ? new MotocicletaId(id) : null;
    }
}