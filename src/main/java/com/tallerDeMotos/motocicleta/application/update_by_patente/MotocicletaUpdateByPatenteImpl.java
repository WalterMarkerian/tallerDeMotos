package com.tallerDeMotos.motocicleta.application.update_by_patente;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MotocicletaUpdateByPatenteImpl implements MotocicletaUpdateByPatente {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaUpdateByPatenteImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    @Transactional
    public MotocicletaDTO updateMotocicletaByPatente(String patente, MotocicletaDTO motocicletaDTO) throws MotocicletaPatenteNotFoundException {
        MotocicletaEntity motocicletaEntity = motocicletaRepository.findByPatente(patente)
                .orElseThrow(MotocicletaPatenteNotFoundException::new);

        motocicletaMapper.updateEntityFromDTO(motocicletaDTO, motocicletaEntity);
        motocicletaEntity = motocicletaRepository.save(motocicletaEntity);

        return motocicletaMapper.toMotocicletaDTO(motocicletaEntity);
    }
}
