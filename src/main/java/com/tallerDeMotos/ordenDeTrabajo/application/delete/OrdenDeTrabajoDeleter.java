package com.tallerDeMotos.ordenDeTrabajo.application.delete;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;

public interface OrdenDeTrabajoDeleter {
    void deleteById(Long id) throws OrdenDeTrabajoNotFoundException;
}
