package com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper(componentModel = "spring")
@Qualifier("ordenDeTrabajoIdMapper")
public interface OrdenDeTrabajoMapper {

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "motocicleta.motocicletaId", target = "motocicletaId")
    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "motocicletaId", target = "motocicleta.motocicletaId")
    OrdenDeTrabajoEntity toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    OrdenDeTrabajo toDomain(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    OrdenDeTrabajo toDomain(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    void updateEntityFromDTO(OrdenDeTrabajoDTO ordenDeTrabajoDTO, @MappingTarget OrdenDeTrabajoEntity ordenDeTrabajoEntity);
}