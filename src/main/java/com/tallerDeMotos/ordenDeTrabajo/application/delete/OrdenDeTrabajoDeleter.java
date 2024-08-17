package com.tallerDeMotos.ordenDeTrabajo.application.delete;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;

public interface OrdenDeTrabajoDeleter {
    void deleteByOrdenDeTrabajoId(OrdenDeTrabajoId ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException;
}
