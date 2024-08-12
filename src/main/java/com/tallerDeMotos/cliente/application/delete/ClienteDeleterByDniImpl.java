package com.tallerDeMotos.cliente.application.delete;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteDeleterByDniImpl implements ClienteDeleterByDni {

    private final ClienteRepository clienteRepository;

    public ClienteDeleterByDniImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void deleteClienteByDni(Long dni) throws ClienteNotFoundException {

        // Verificar si el cliente existe antes de eliminarlo
        if (!clienteRepository.existsByDni(dni)) {
            throw new ClienteNotFoundException();
        }
        clienteRepository.deleteByDni(dni);
    }
}
