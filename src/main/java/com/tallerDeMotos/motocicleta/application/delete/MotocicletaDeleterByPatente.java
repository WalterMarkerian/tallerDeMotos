package com.tallerDeMotos.motocicleta.application.delete;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;

public interface MotocicletaDeleterByPatente {
    void deleteByPatente(String patente) throws MotocicletaPatenteNotFoundException;
}
