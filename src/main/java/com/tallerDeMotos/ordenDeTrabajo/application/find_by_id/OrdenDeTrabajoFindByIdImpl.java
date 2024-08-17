package com.tallerDeMotos.ordenDeTrabajo.application.find_by_id;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoFindByIdImpl implements OrdenDeTrabajoFindById {

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;


    @Override
    public OrdenDeTrabajoDTO getOrdenDeTrabajoByOrdenDeTrabajoId(OrdenDeTrabajoId ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoRepository.findByOrdenDeTrabajoId(ordenDeTrabajoId)
                .orElseThrow(OrdenDeTrabajoNotFoundException::new);

        return ordenDeTrabajoMapper.toDTO(ordenDeTrabajoEntity);
    }
}
