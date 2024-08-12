package com.tallerDeMotos.motocicleta.application.find_by_patente;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaFindByPatente  {
    MotocicletaDTO getMotocicletaByPatente(String patente) throws MotocicletaPatenteNotFoundException;
}
