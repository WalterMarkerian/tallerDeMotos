package com.tallerDeMotos.motocicleta.application.find_by_patente;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;

@Service
public class MotocicletaFindByPatenteImpl implements MotocicletaFindByPatente {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaFindByPatenteImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    public MotocicletaDTO getMotocicletaByPatente(String patente) throws MotocicletaPatenteNotFoundException {
        MotocicletaEntity motocicletaEntity = motocicletaRepository.findByPatente(patente)
                .orElseThrow(MotocicletaPatenteNotFoundException::new);

        return motocicletaMapper.toDTO(motocicletaEntity);
    }
}
