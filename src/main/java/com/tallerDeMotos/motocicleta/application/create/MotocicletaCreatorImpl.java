package com.tallerDeMotos.motocicleta.application.create;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotocicletaCreatorImpl implements MotocicletaCreator {
    @Autowired
    private MotocicletaRepository motocicletaRepository;
    @Autowired
    private MotocicletaMapper motocicletaMapper;
    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    @Override
    @Transactional
    public MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDuplicatePatenteException, ClienteNotFoundException {
        if (motocicletaRepository.existsByPatente(motocicletaDTO.getPatente())) {
            throw new MotocicletaDuplicatePatenteException();
        }
        ClienteEntity clienteEntity = clienteRepository.findById(motocicletaDTO.getClienteId())
                .orElseThrow(ClienteNotFoundException::new);
        Motocicleta motocicleta = motocicletaMapper.toMotocicletaDomain(motocicletaDTO);
        MotocicletaEntity motocicletaEntity = motocicletaMapper.toMotocicletaEntity(motocicleta);
        motocicletaEntity.setCliente(clienteEntity);
        MotocicletaEntity savedMotocicletaEntity = motocicletaRepository.save(motocicletaEntity);
        return motocicletaMapper.toMotocicletaDTO(savedMotocicletaEntity);
    }
}
