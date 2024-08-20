package com.tallerDeMotos.motocicleta.application.find_by_patente;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotocicletaFindByPatenteImpl implements MotocicletaFindByPatente {
    @Autowired
    private MotocicletaRepository motocicletaRepository;
    @Autowired
    private MotocicletaMapper motocicletaMapper;

    @Override
    public MotocicletaDTO getMotocicletaByPatente(String patente) throws MotocicletaPatenteNotFoundException {
        MotocicletaEntity motocicletaEntity = motocicletaRepository.findByPatente(patente)
                .orElseThrow(MotocicletaPatenteNotFoundException::new);
        return motocicletaMapper.toMotocicletaDTO(motocicletaEntity);
    }
}
