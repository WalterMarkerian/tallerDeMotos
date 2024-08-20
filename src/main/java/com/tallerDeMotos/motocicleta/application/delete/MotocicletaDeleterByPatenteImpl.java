package com.tallerDeMotos.motocicleta.application.delete;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotocicletaDeleterByPatenteImpl implements MotocicletaDeleterByPatente {
    @Autowired
    private MotocicletaRepository motocicletaRepository;

    @Override
    @Transactional
    public void deleteByPatente(String patente) throws MotocicletaPatenteNotFoundException {
        if (!motocicletaRepository.existsByPatente(patente)) {
            throw new MotocicletaPatenteNotFoundException();
        }
        motocicletaRepository.deleteByPatente(patente);
    }
}
