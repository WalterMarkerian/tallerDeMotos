package com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository;

import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajoEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN TRUE ELSE FALSE END FROM OrdenDeTrabajoEntity o WHERE o.ordenDeTrabajoId.id = :id")
    boolean existByOrdenDeTrabajoId(@Param("id") Long id);
    Optional<OrdenDeTrabajoEntity> findByOrdenDeTrabajoId(OrdenDeTrabajoId ordenDeTrabajoId);

}
