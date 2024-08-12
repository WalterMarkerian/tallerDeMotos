package com.tallerDeMotos.cliente.application.find_by_dni;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteFindByDniImpl implements ClienteFindByDni {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteFindByDniImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO getClienteByDni(Long dni) throws ClienteNotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findByDni(dni)
                .orElseThrow(ClienteNotFoundException::new);

        return clienteMapper.toDTO(clienteEntity);
    }
}
