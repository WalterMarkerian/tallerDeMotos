package com.tallerDeMotos.cliente.infrastructure.mapper;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = MotocicletaMapper.class)
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "motocicletas", target = "motocicletas")
    ClienteDTO toDTO(ClienteEntity clienteEntity); // Convierte ClienteEntity a ClienteDTO

    @Mapping(source = "motocicletas", target = "motocicletas")
    ClienteEntity toEntity(Cliente cliente); // Convierte Cliente a ClienteEntity

    Cliente toDomain(ClienteDTO clienteDTO); // Convierte ClienteDTO a Cliente

    Cliente toDomain(ClienteEntity clienteEntity); // Convierte ClienteEntity a Cliente

    @Mapping(source = "motocicletas", target = "motocicletas")
    void updateEntityFromDTO(ClienteDTO clienteDTO, @MappingTarget ClienteEntity clienteEntity);
}