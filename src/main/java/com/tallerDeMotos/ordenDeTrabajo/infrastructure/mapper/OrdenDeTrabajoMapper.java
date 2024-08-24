package com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrdenDeTrabajoMapper {

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "motocicleta.motocicletaId", target = "motocicletaId")
    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "motocicletaId", target = "motocicleta.motocicletaId")
    OrdenDeTrabajoEntity toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    @Mapping(source = "motocicletaId", target = "motocicleta")
    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    OrdenDeTrabajo toDomain(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    default Motocicleta mapMotocicletaIdToMotocicleta(Long motocicletaId) {
        if (motocicletaId == null) {
            return null;
        }
        Motocicleta motocicleta = new Motocicleta();
        motocicleta.setMotocicletaId(motocicletaId);
        return motocicleta;
    }

    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    OrdenDeTrabajo toDomain(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    void updateEntityFromDTO(OrdenDeTrabajoDTO ordenDeTrabajoDTO, @MappingTarget OrdenDeTrabajoEntity ordenDeTrabajoEntity);
}

//@Mapper(componentModel = "spring")
//public interface OrdenDeTrabajoMapper {
//
//    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
//    @Mapping(source = "motocicleta.motocicletaId", target = "motocicletaId")
//    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajoEntity ordenDeTrabajoEntity);
//
//    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
//    @Mapping(source = "motocicletaId", target = "motocicleta.motocicletaId")
//    OrdenDeTrabajoEntity toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);
//
//    @Mapping(source = "motocicletaId", target = "motocicleta", qualifiedByName = "mapMotocicletaIdToMotocicleta")
//    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
//    OrdenDeTrabajo toDomain(OrdenDeTrabajoDTO ordenDeTrabajoDTO);
//
//    default Motocicleta mapMotocicletaIdToMotocicleta(Long motocicletaId) {
//        if (motocicletaId == null) {
//            return null;
//        }
//        Motocicleta motocicleta = new Motocicleta();
//        motocicleta.setMotocicletaId(motocicletaId);
//        return motocicleta;
//    }
//
//    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
//    @Mapping(source = "motocicleta.motocicletaId", target = "motocicletaId")
//    OrdenDeTrabajo toDomain(OrdenDeTrabajoEntity ordenDeTrabajoEntity);
//
//    void updateEntityFromDTO(OrdenDeTrabajoDTO ordenDeTrabajoDTO, @MappingTarget OrdenDeTrabajoEntity ordenDeTrabajoEntity);
//}