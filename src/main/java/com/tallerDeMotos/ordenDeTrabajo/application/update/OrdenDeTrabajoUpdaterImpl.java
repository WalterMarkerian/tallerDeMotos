package com.tallerDeMotos.ordenDeTrabajo.application.update;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoUpdaterImpl implements OrdenDeTrabajoUpdater {
    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;


    @Override
    public OrdenDeTrabajoDTO updateOrdenDeTrabajoById(Long ordenDeTrabajoId, OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoRepository.findById(ordenDeTrabajoId)
                .orElseThrow(OrdenDeTrabajoNotFoundException::new);

        ordenDeTrabajoMapper.updateEntityFromDTO(ordenDeTrabajoDTO, ordenDeTrabajoEntity);
        ordenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajoEntity);

        return ordenDeTrabajoMapper.toDTO(ordenDeTrabajoEntity);
    }
}
