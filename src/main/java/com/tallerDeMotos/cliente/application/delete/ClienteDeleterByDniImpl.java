package com.tallerDeMotos.cliente.application.delete;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteDeleterByDniImpl implements ClienteDeleterByDni {

    private final ClienteRepository clienteRepository;

    public ClienteDeleterByDniImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void deleteClienteByDni(Long dni) throws ClienteNotFoundException {

        Optional<ClienteEntity> clienteOptional = clienteRepository.findByDni(dni);

        if (clienteOptional.isPresent()) {
            // Eliminar el cliente si existe
            clienteRepository.delete(clienteOptional.get());
        } else {
            // Lanzar una excepción si el cliente no existe
            throw new ClienteNotFoundException();
        }
    }
}
