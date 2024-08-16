package com.tallerDeMotos.ordenDeTrabajo.application.delete;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrdenDeTrabajoDeletermpl implements OrdenDeTrabajoDeleter {
    @Override
    public void deleteById(Long id) throws OrdenDeTrabajoNotFoundException {

    }
}
