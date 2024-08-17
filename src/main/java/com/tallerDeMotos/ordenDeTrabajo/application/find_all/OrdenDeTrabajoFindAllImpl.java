package com.tallerDeMotos.ordenDeTrabajo.application.find_all;

import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrdenDeTrabajoFindAllImpl implements OrdenDeTrabajoFindAll {

    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;


    @Override
    public List<OrdenDeTrabajoDTO> getAllOrdenesDeTrabajo() throws OrdenDeTrabajoNotFoundException {
        List<OrdenDeTrabajoEntity> ordenDeTrabajoEntities = ordenDeTrabajoRepository.findAll();
        if(ordenDeTrabajoEntities.isEmpty()){
            throw new OrdenDeTrabajoNotFoundException();
        }
        return ordenDeTrabajoEntities.stream()
                .map(ordenDeTrabajoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
