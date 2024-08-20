package com.tallerDeMotos.ordenDeTrabajo.application.delete;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;

public interface OrdenDeTrabajoDeleter {
    void deleteByOrdenDeTrabajoId(Long ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException;
}
