package com.tallerDeMotos.motocicleta.application.find_all;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;

import java.util.List;

public interface MotocicletaFindAll {
    List<MotocicletaDTO> getAllMotocicletas() throws MotocicletasNotFoundException;
}
