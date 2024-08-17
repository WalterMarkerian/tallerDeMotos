package com.tallerDeMotos.ordenDeTrabajo.application.delete;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdenDeTrabajoDeletermpl implements OrdenDeTrabajoDeleter {

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Override
    public void deleteByOrdenDeTrabajoId(OrdenDeTrabajoId ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException {
        Optional<OrdenDeTrabajoEntity> ordenDeTrabajoOptional = ordenDeTrabajoRepository.findById(ordenDeTrabajoId.getId());

        if (ordenDeTrabajoOptional.isPresent()) {
            ordenDeTrabajoRepository.delete(ordenDeTrabajoOptional.get());
        } else {
            throw new OrdenDeTrabajoNotFoundException();
        }
    }
}
