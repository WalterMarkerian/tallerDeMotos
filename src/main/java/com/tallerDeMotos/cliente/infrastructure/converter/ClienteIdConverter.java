//package com.tallerDeMotos.cliente.infrastructure.converter;
//
//import com.tallerDeMotos.cliente.domain.ClienteId;
//import com.tallerDeMotos.commons.infrastructure.converter.AbstractIdConverter;
//import jakarta.persistence.Converter;
//
//@Converter(autoApply = true)
//public class ClienteIdConverter extends AbstractIdConverter<ClienteId> {
//
//    @Override
//    protected Long getIdValue(ClienteId id) {
//        return id.getId();
//    }
//
//    @Override
//    protected ClienteId createId(Long idValue) {
//        return new ClienteId(idValue);
//    }
//}