package com.tallerDeMotos.motocicleta.application.find_all;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotocicletaFindAllImpl implements MotocicletaFindAll {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaFindAllImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    public List<MotocicletaDTO> getAllMotocicletas() throws MotocicletasNotFoundException {
        List<MotocicletaEntity> motocicletaEntities = motocicletaRepository.findAll();
        if (motocicletaEntities.isEmpty()) {
            throw new MotocicletasNotFoundException();
        }
        return motocicletaEntities.stream()
                .map(motocicletaMapper::toMotocicletaDTO)
                .collect(Collectors.toList());
    }
}
