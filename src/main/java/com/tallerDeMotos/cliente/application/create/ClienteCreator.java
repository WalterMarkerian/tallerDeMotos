package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;

public interface ClienteCreator {
    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException, MotocicletaDuplicatePatenteException, ClienteNotFoundException;

}
