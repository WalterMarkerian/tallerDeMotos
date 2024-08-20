package com.tallerDeMotos.motocicleta.application.create;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaCreator {
    MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDuplicatePatenteException, ClienteNotFoundException;
}
