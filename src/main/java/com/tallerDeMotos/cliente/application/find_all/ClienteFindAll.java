package com.tallerDeMotos.cliente.application.find_all;

import com.tallerDeMotos.cliente.domain.exception.ClientesNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;

import java.util.List;

public interface ClienteFindAll {
    List<ClienteDTO> getAllClientes() throws ClientesNotFoundException;
}