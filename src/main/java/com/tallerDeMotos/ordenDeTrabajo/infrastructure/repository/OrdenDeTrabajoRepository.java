package com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository;

import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajoEntity, Long> {
}
