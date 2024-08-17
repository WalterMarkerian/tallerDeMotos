package com.tallerDeMotos.cliente.infrastructure.mapper;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper(componentModel = "spring", uses = ClienteIdMapper.class)
@Qualifier("clienteIdMapper")
public interface ClienteMapper {

//    @Mapping(source = "clienteId", target = "clienteId")
    ClienteDTO toClienteDTO(ClienteEntity clienteEntity);

//    @Mapping(source = "clienteId", target = "clienteId")
    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toDomain(ClienteDTO clienteDTO);

    Cliente toDomain(ClienteEntity clienteEntity);

    void updateEntityFromDTO(ClienteDTO clienteDTO, @MappingTarget ClienteEntity clienteEntity);
}