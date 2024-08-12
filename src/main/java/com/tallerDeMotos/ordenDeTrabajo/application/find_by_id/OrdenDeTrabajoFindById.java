package com.tallerDeMotos.ordenDeTrabajo.application.find_by_id;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;

public interface OrdenDeTrabajoFindById {
    OrdenDeTrabajoDTO getOrdenDeTrabajoById(Long id) throws OrdenDeTrabajoNotFoundException;
}
