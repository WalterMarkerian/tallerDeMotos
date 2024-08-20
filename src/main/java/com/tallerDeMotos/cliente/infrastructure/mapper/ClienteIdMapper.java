//package com.tallerDeMotos.cliente.infrastructure.mapper;
//
//import com.tallerDeMotos.cliente.domain.ClienteId;
//import org.mapstruct.Mapper;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//@Mapper(componentModel = "spring")
//@Qualifier("clienteIdMapper")
//
//public interface ClienteIdMapper  {
//
//    // Mapea ClienteId a Long
//    default Long toLong(ClienteId clienteId) {
//        return clienteId != null ? clienteId.getId() : null;
//    }
//
//    // Mapea Long a ClienteId
//    default ClienteId toClienteId(Long id) {
//        return id != null ? new ClienteId(id) : null;
//    }
//}