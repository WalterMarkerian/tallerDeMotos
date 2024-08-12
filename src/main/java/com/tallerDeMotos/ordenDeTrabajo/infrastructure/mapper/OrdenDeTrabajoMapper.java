package com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper;

import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = MotocicletaMapper.class)
public interface OrdenDeTrabajoMapper {

    @Mapping(source = "motocicleta", target = "motocicleta")
    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    @Mapping(source = "motocicleta", target = "motocicleta")
    OrdenDeTrabajoEntity toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    OrdenDeTrabajo toDomain(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    OrdenDeTrabajo toDomain(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    void updateEntityFromDTO(OrdenDeTrabajoDTO ordenDeTrabajoDTO, @MappingTarget OrdenDeTrabajoEntity ordenDeTrabajoEntity);
}
