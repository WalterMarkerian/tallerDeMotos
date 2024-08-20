package com.tallerDeMotos.ordenDeTrabajo.application.update;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;

public interface OrdenDeTrabajoUpdater {
    OrdenDeTrabajoDTO updateOrdenDeTrabajoById(Long ordenDeTrabajoId, OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoNotFoundException;
}
