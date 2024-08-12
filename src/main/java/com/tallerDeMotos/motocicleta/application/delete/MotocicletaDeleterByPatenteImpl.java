package com.tallerDeMotos.motocicleta.application.delete;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotocicletaDeleterByPatenteImpl implements MotocicletaDeleterByPatente {

    private final MotocicletaRepository motocicletaRepository;

    public MotocicletaDeleterByPatenteImpl(MotocicletaRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;
    }

    @Override
    @Transactional
    public void deleteByPatente(String patente) throws MotocicletaPatenteNotFoundException {

        // Verificar si el cliente existe antes de eliminarlo
        if (!motocicletaRepository.existsByPatente(patente)) {
            throw new MotocicletaPatenteNotFoundException();
        }

        motocicletaRepository.deleteByPatente(patente);
    }
}
