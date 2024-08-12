package com.tallerDeMotos.motocicleta.application.create;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MotocicletaCreatorImpl implements MotocicletaCreator {
    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaCreatorImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    @Transactional
    public MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDuplicatePatenteException {
        // Verifica si la patente ya existe
        if (motocicletaRepository.existsByPatente(motocicletaDTO.getPatente())) {
            throw new MotocicletaDuplicatePatenteException();
        }

        // Mapea el DTO a dominio
        Motocicleta motocicleta = motocicletaMapper.toDomain(motocicletaDTO);

        // Mapea el dominio a entidad
        MotocicletaEntity motocicletaEntity = motocicletaMapper.toEntity(motocicleta);

        // Guarda la entidad en la base de datos
        MotocicletaEntity savedMotocicletaEntity = motocicletaRepository.save(motocicletaEntity);

        // Mapea la entidad guardada a DTO
        return motocicletaMapper.toDTO(savedMotocicletaEntity);
    }
}
