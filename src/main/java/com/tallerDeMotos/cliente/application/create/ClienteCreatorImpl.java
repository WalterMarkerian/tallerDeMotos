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

        // Mapeo de ClienteDTO a Cliente y ClienteEntity
        Cliente cliente = clienteMapper.toDomain(clienteDTO);
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(cliente);

        // Asignar el cliente a cada motocicleta y gestionar las órdenes de trabajo
        if (clienteEntity.getMotocicletas() != null) {
            for (MotocicletaEntity motocicleta : clienteEntity.getMotocicletas()) {
                motocicleta.setCliente(clienteEntity);

                // Verifica que la lista de ordenesDeTrabajo no sea nula
                if (motocicleta.getOrdenesDeTrabajo() == null) {
                    motocicleta.setOrdenesDeTrabajo(new ArrayList<>()); // Inicializa la lista si es nula
                }

                // Añade cada orden de trabajo a la motocicleta
                if (motocicleta.getOrdenesDeTrabajo() != null) {
                    for (OrdenDeTrabajoEntity orden : motocicleta.getOrdenesDeTrabajo()) {
                        orden.setMotocicleta(motocicleta);
                    }
                }
            }
        }

        // Guardar cliente en la base de datos
        clienteRepository.save(clienteEntity);

        // Retornar el ClienteDTO
        return clienteMapper.toClienteDTO(clienteEntity);
    }
}