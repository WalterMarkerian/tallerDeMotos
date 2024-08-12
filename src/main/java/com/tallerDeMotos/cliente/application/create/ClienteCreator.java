package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
public interface ClienteCreator {
    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException;

}
