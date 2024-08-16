package com.tallerDeMotos.ordenDeTrabajo.application.find_by_id;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoFindByIdImpl implements OrdenDeTrabajoFindById {

    private final OrdenDeTrabajoRepository ordenDeTrabajoRepository;
    private final OrdenDeTrabajoMapper ordenDeTrabajoMapper;

    public OrdenDeTrabajoFindByIdImpl(OrdenDeTrabajoRepository ordenDeTrabajoRepository, OrdenDeTrabajoMapper ordenDeTrabajoMapper) {
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
    }

    @Override
    public OrdenDeTrabajoDTO getOrdenDeTrabajoById(Long id) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoRepository.findById(id)
                .orElseThrow(OrdenDeTrabajoNotFoundException::new);

        return ordenDeTrabajoMapper.toDTO(ordenDeTrabajoEntity);
    }
}
