package com.tallerDeMotos.cliente.infrastructure.mapper;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MotocicletaMapper.class})
//@Qualifier("clienteIdMapper")
public interface ClienteMapper {

    @Mapping(target = "motocicletas", expression = "java(setClienteIdInMotocicletas(clienteEntity))")
    ClienteDTO toClienteDTO(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toDomain(ClienteDTO clienteDTO);

    Cliente toDomain(ClienteEntity clienteEntity);

    void updateEntityFromDTO(ClienteDTO clienteDTO, @MappingTarget ClienteEntity clienteEntity);

    default List<MotocicletaDTO> setClienteIdInMotocicletas(ClienteEntity clienteEntity) {
        List<MotocicletaDTO> motocicletas = motocicletaEntityListToMotocicletaDTOList(clienteEntity.getMotocicletas());
        if (motocicletas != null) {
            motocicletas.forEach(moto -> {
                moto.setClienteId(clienteEntity.getClienteId());
                moto.setOrdenesDeTrabajo(
                        ordenDeTrabajoEntityListToOrdenDeTrabajoDTOList(moto.getOrdenesDeTrabajo())
                );
            });
        }
        return motocicletas;
    }

    List<MotocicletaDTO> motocicletaEntityListToMotocicletaDTOList(List<MotocicletaEntity> motocicletas);

    List<OrdenDeTrabajoDTO> ordenDeTrabajoEntityListToOrdenDeTrabajoDTOList(List<OrdenDeTrabajoDTO> ordenesDeTrabajo);
}
