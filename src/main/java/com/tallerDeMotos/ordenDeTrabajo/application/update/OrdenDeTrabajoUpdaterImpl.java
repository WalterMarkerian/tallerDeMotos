package com.tallerDeMotos.ordenDeTrabajo.application.update;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoUpdaterImpl implements OrdenDeTrabajoUpdater {
    private final OrdenDeTrabajoRepository ordenDeTrabajoRepository;
    private final OrdenDeTrabajoMapper ordenDeTrabajoMapper;

    public OrdenDeTrabajoUpdaterImpl(OrdenDeTrabajoRepository ordenDeTrabajoRepository, OrdenDeTrabajoMapper ordenDeTrabajoMapper) {
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
    }

    @Override
    public OrdenDeTrabajoDTO updateOrdenDeTrabajoById(Long id, OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoEntity ordenDeTrabajoEntity = ordenDeTrabajoRepository.findById(id)
                .orElseThrow(OrdenDeTrabajoNotFoundException::new);

        ordenDeTrabajoMapper.updateEntityFromDTO(ordenDeTrabajoDTO, ordenDeTrabajoEntity);
        ordenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajoEntity);

        return ordenDeTrabajoMapper.toDTO(ordenDeTrabajoEntity);
    }
}
