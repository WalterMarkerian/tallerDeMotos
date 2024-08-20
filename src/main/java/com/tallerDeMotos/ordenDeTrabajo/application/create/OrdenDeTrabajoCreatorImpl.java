package com.tallerDeMotos.ordenDeTrabajo.application.create;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoCreatorImpl implements OrdenDeTrabajoCreater {

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private MotocicletaRepository motocicletaRepository;

    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;


//    public OrdenDeTrabajoDTO createOrdenDeTrabajo(OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException {
//        if (ordenDeTrabajoRepository.existByOrdenDeTrabajoId(ordenDeTrabajoDTO.getOrdenDeTrabajoId().getId())) {
//            throw new OrdenDeTrabajoDuplicateIdException();
//        }
//
//        OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoMapper.toDomain(ordenDeTrabajoDTO);
//
//        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoMapper.toEntity(ordenDeTrabajoDTO);
//
//        OrdenDeTrabajoEntity savedOrdenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajoEntity);
//
//        return ordenDeTrabajoMapper.toDTO(savedOrdenDeTrabajoEntity);
//    }

    @Override
    public OrdenDeTrabajoDTO createOrdenDeTrabajo(OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException, MotocicletasNotFoundException {
        // Verificar si la orden de trabajo ya existe
        if (ordenDeTrabajoRepository.existsByOrdenDeTrabajoId(ordenDeTrabajoDTO.getOrdenDeTrabajoId())) {
            throw new OrdenDeTrabajoDuplicateIdException();
        }

        // Verificar si la motocicleta existe
        Long motocicletaId = ordenDeTrabajoDTO.getMotocicletaId();
        if (!motocicletaRepository.existsById(motocicletaId)) {
            throw new MotocicletasNotFoundException();
        }

        // Convertir DTO a dominio y entidad
        OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoMapper.toDomain(ordenDeTrabajoDTO);
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoMapper.toEntity(ordenDeTrabajoDTO);

        // Guardar la orden de trabajo
        OrdenDeTrabajoEntity savedOrdenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajoEntity);

        // Convertir la entidad guardada de vuelta a DTO
        return ordenDeTrabajoMapper.toDTO(savedOrdenDeTrabajoEntity);
    }
}

