package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteCreatorImpl implements ClienteCreator {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    @Override
    @Transactional
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException {
        if (clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteDuplicateDniException();
        }
        Cliente cliente = clienteMapper.toDomain(clienteDTO);
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);

        return clienteMapper.toClienteDTO(clienteEntity);
    }
}
