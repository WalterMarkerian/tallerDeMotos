package com.tallerDeMotos.ordenDeTrabajo.application.find_all;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;

import java.util.List;

public interface OrdenDeTrabajoFindAll {
    List<OrdenDeTrabajoDTO> getAllOrdenesDeTrabajo() throws OrdenDeTrabajoNotFoundException;
}
