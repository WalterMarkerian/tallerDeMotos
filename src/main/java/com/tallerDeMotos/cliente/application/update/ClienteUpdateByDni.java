package com.tallerDeMotos.cliente.application.update;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;

public interface ClienteUpdateByDni {
    ClienteDTO updateClienteByDni(Long dni, ClienteDTO clienteDTO) throws ClienteNotFoundException;
}