package com.tallerDeMotos.cliente.application.update;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteUpdateByDniImpl implements ClienteUpdateByDni {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteUpdateByDniImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO updateClienteByDni(Long dni, ClienteDTO clienteDTO) throws ClienteNotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findByDni(dni)
                .orElseThrow(ClienteNotFoundException::new);

        clienteMapper.updateEntityFromDTO(clienteDTO, clienteEntity);
        clienteEntity = clienteRepository.save(clienteEntity);
        return clienteMapper.toClienteDTO(clienteEntity);
    }
}