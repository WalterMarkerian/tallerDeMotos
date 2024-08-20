//package com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper;
//
//import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
//import org.mapstruct.Mapper;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//@Mapper(componentModel = "spring")
//@Qualifier("ordenDeTrabajoIdMapper")
//public interface OrdenDeTrabajoIdMapper  {
//
//    // Convierte OrdenDeTrabajoId a Long
//    default Long map(OrdenDeTrabajoId ordenDeTrabajoId) {
//        return ordenDeTrabajoId != null ? ordenDeTrabajoId.getId() : null;
//    }
//
//    // Convierte Long a OrdenDeTrabajoId
//    default OrdenDeTrabajoId map(Long id) {
//        return id != null ? new OrdenDeTrabajoId(id) : null;
//    }
//}