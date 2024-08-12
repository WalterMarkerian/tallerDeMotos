package com.tallerDeMotos.cliente.application.find_by_dni;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;

public interface ClienteFindByDni {
    ClienteDTO getClienteByDni(Long dni) throws ClienteNotFoundException;

}
