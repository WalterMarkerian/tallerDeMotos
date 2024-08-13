package com.tallerDeMotos.cliente.infrastructure.mapper;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MotocicletaMapper.class})
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    // Mapea de ClienteDTO a Cliente (Entidad del Dominio)
    Cliente toCliente(ClienteDTO clienteDTO);

    // Mapea de Cliente a ClienteDTO
    ClienteDTO toClienteDTO(Cliente cliente);

    // Mapea de ClienteEntity a Cliente (Entidad del Dominio)
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    Cliente toCliente(ClienteEntity clienteEntity);

    // Mapea de Cliente a ClienteEntity
    ClienteEntity toClienteEntity(Cliente cliente);

    // Mapea de ClienteEntity a ClienteDTO
    ClienteDTO toClienteDTO(ClienteEntity clienteEntity);

    // Actualiza una entidad ClienteEntity con los datos de ClienteDTO
    @Mapping(target = "id", ignore = true) // No se actualiza el ID
    void updateEntityFromDTO(ClienteDTO clienteDTO, @MappingTarget ClienteEntity clienteEntity);

}
