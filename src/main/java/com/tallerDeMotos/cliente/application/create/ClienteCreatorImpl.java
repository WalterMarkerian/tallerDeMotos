package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import com.tallerDeMotos.motocicleta.application.create.MotocicletaCreator;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.motocicleta.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteCreatorImpl implements ClienteCreator {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private MotocicletaCreator motocicletaCreator;
    @Autowired
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;
    @Autowired
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;
    @Autowired
    private MotocicletaRepository motocicletaRepository;

    @Override
    @Transactional
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException {
        if (clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteDuplicateDniException();
        }
        Cliente cliente = clienteMapper.toDomain(clienteDTO);
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(cliente);
        if (clienteEntity.getMotocicletas() != null) {
            for (MotocicletaEntity motocicleta : clienteEntity.getMotocicletas()) {
                motocicleta.setCliente(clienteEntity);
                if (motocicleta.getOrdenesDeTrabajo() == null) {
                    motocicleta.setOrdenesDeTrabajo(new ArrayList<>()); // Inicializa la lista si es nula
                }
                if (motocicleta.getOrdenesDeTrabajo() != null) {
                    for (OrdenDeTrabajoEntity orden : motocicleta.getOrdenesDeTrabajo()) {
                        orden.setMotocicleta(motocicleta);
                    }
                }
            }
        }
        clienteRepository.save(clienteEntity);
        return clienteMapper.toClienteDTO(clienteEntity);
    }
}