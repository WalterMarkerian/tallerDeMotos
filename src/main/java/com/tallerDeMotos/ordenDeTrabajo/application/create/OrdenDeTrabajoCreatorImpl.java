package com.tallerDeMotos.ordenDeTrabajo.application.create;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoCreatorImpl implements OrdenDeTrabajoCreater {

    private final OrdenDeTrabajoRepository ordenDeTrabajoRepository;
    private final OrdenDeTrabajoMapper ordenDeTrabajoMapper;

    public OrdenDeTrabajoCreatorImpl(OrdenDeTrabajoRepository ordenDeTrabajoRepository, OrdenDeTrabajoMapper ordenDeTrabajoMapper) {
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
    }

    public OrdenDeTrabajoDTO createOrdenDeTrabajo(OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException {
        // Verificar si la orden de trabajo ya existe en la base de datos
        if (ordenDeTrabajoRepository.existsById(ordenDeTrabajoDTO.getId())) {
            throw new OrdenDeTrabajoDuplicateIdException();
        }

        // Convertir el DTO a la entidad de dominio
        OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoMapper.toDomain(ordenDeTrabajoDTO);

        // Convertir la entidad de dominio a entidad JPA
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoMapper.toEntity(ordenDeTrabajoDTO);

        // Guardar la entidad en la base de datos
        OrdenDeTrabajoEntity savedOrdenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajoEntity);

        // Convertir la entidad guardada de nuevo a DTO
        return ordenDeTrabajoMapper.toDTO(savedOrdenDeTrabajoEntity);
    }
}

