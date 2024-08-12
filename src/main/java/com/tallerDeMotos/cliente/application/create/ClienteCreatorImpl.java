package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteCreatorImpl implements ClienteCreator {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteCreatorImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException {
        // Verifica si el DNI ya existe
        if (clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteDuplicateDniException();
        }

        // Mapea el DTO a dominio
        Cliente cliente = clienteMapper.toDomain(clienteDTO);

        // Mapea el dominio a entidad
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);

        // Guarda la entidad en la base de datos
        clienteEntity = clienteRepository.save(clienteEntity);

        // Convertimos la entidad guardada de nuevo a DTO y lo retornamos
        return clienteMapper.toDTO(clienteEntity);
    }
}
