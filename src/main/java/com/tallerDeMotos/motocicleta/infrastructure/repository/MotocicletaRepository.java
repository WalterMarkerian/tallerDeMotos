package com.tallerDeMotos.motocicleta.infrastructure.repository;


import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotocicletaRepository extends JpaRepository<MotocicletaEntity, Long> {
    void deleteByPatente(String patente);

    Optional<MotocicletaEntity> findByPatente(String patente);

    // Método para verificar si existe una motocicleta con la patente dada
    boolean existsByPatente(String patente);

}
