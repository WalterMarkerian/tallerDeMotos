//package com.tallerDeMotos.motocicleta.infrastructure.converter;
//
//import com.tallerDeMotos.commons.infrastructure.converter.AbstractIdConverter;
//import com.tallerDeMotos.motocicleta.domain.MotocicletaId;
//import jakarta.persistence.Converter;
//
//@Converter(autoApply = true)
//public class MotocicletaIdConverter extends AbstractIdConverter<MotocicletaId> {
//
//    @Override
//    protected Long getIdValue(MotocicletaId id) {
//        return id.getId();
//    }
//
//    @Override
//    protected MotocicletaId createId(Long idValue) {
//        return new MotocicletaId(idValue);
//    }
//}
