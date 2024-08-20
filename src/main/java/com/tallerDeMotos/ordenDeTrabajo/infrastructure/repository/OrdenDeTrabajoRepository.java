package com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository;

import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajoEntity, Long> {
    boolean existsByOrdenDeTrabajoId(Long ordenDeTrabajoId);
    Optional<OrdenDeTrabajoEntity> findByOrdenDeTrabajoId(Long ordenDeTrabajoId);
}
