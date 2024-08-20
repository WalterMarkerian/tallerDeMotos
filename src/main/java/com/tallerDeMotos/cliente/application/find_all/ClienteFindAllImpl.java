package com.tallerDeMotos.cliente.application.find_all;

import com.tallerDeMotos.cliente.domain.exception.ClientesNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteFindAllImpl implements ClienteFindAll {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> getAllClientes() throws ClientesNotFoundException {
        List<ClienteEntity> clienteEntities = clienteRepository.findAll();
        if (clienteEntities.isEmpty()) {
            throw new ClientesNotFoundException();
        }
        return clienteEntities.stream()
                .map(clienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }
}