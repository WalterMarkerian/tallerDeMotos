package com.tallerDeMotos.cliente.infrastructure.repository;

import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    void deleteByDni(String dni);

    Optional<ClienteEntity> findByDni(String dni);

    boolean existsByDni(String dni);
}