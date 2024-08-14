package com.tallerDeMotos.motocicleta.infrastructure.mapper;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MotocicletaMapper {

    MotocicletaMapper INSTANCE = Mappers.getMapper(MotocicletaMapper.class);

    MotocicletaDTO toMotocicletaDTO(MotocicletaEntity motocicletaEntity);

    Motocicleta toMotocicletaDomain(MotocicletaDTO motocicletaDTO);

    MotocicletaEntity toMotocicletaEntity(Motocicleta motocicleta);

    void updateEntityFromDTO(MotocicletaDTO motocicletaDTO, @MappingTarget MotocicletaEntity motocicletaEntity);

}
