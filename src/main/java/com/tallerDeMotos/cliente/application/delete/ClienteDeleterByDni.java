package com.tallerDeMotos.cliente.application.delete;


import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;

public interface ClienteDeleterByDni {
    void deleteClienteByDni(Long dni) throws ClienteNotFoundException;
}
