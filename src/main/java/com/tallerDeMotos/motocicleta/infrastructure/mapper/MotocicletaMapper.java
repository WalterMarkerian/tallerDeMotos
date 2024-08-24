package com.tallerDeMotos.motocicleta.infrastructure.mapper;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

//@Mapper(componentModel = "spring")
//public interface MotocicletaMapper {
//    @Mapping(source = "motocicletaId", target = "motocicletaId")
//    MotocicletaDTO toMotocicletaDTO(MotocicletaEntity motocicletaEntity);
//
//    @Mapping(source = "motocicletaId", target = "motocicletaId")
//    MotocicletaEntity toMotocicletaEntity(Motocicleta motocicleta);
//
//    @Mapping(target = "motocicletaId", source = "motocicletaId")
//    Motocicleta toMotocicletaDomain(MotocicletaDTO motocicletaDTO);
//
//    @Mapping(target = "motocicletaId", source = "motocicletaId")
//    Motocicleta toMotocicletaDomain(MotocicletaEntity motocicletaEntity);
//
//    void updateEntityFromDTO(MotocicletaDTO motocicletaDTO, @MappingTarget MotocicletaEntity motocicletaEntity);
//}

@Mapper(componentModel = "spring", uses = OrdenDeTrabajoMapper.class)
public interface MotocicletaMapper {

    @Mapping(source = "motocicletaId", target = "motocicletaId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    MotocicletaDTO toMotocicletaDTO(MotocicletaEntity motocicletaEntity);

    @Mapping(source = "motocicletaId", target = "motocicletaId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    MotocicletaEntity toMotocicletaEntity(Motocicleta motocicleta);

    @Mapping(target = "motocicletaId", source = "motocicletaId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    Motocicleta toMotocicletaDomain(MotocicletaDTO motocicletaDTO);

    @Mapping(target = "motocicletaId", source = "motocicletaId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    Motocicleta toMotocicletaDomain(MotocicletaEntity motocicletaEntity);

    void updateEntityFromDTO(MotocicletaDTO motocicletaDTO, @MappingTarget MotocicletaEntity motocicletaEntity);
}