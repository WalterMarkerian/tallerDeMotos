package com.tallerDeMotos.motocicleta.application.update_by_patente;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaUpdateByPatente {
    MotocicletaDTO updateMotocicletaByPatente(String patente, MotocicletaDTO motocicletaDTO) throws MotocicletaPatenteNotFoundException;
}
