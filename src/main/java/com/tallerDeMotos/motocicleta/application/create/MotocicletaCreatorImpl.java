package com.tallerDeMotos.motocicleta.application.create;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MotocicletaCreatorImpl implements MotocicletaCreator {
    @Autowired
    private MotocicletaRepository motocicletaRepository;

    @Autowired
    private MotocicletaMapper motocicletaMapper;

    @Override
    @Transactional
    public MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDuplicatePatenteException {
        if (motocicletaRepository.existsByPatente(motocicletaDTO.getPatente())) {
            throw new MotocicletaDuplicatePatenteException();
        }

        Motocicleta motocicleta = motocicletaMapper.toMotocicletaDomain(motocicletaDTO);
        MotocicletaEntity motocicletaEntity = motocicletaMapper.toMotocicletaEntity(motocicleta);
        MotocicletaEntity savedMotocicletaEntity = motocicletaRepository.save(motocicletaEntity);
        return motocicletaMapper.toMotocicletaDTO(savedMotocicletaEntity);
    }
}
