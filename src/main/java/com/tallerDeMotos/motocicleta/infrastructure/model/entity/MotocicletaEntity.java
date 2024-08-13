package com.tallerDeMotos.motocicleta.infrastructure.model.entity;

import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.motocicleta.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "motocicletas")
@Data
public class MotocicletaEntity {
    // Es la entidad JPA que representa la estructura de la base de datos.
    // Especifica cómo se almacenan los datos en la base de datos y permite la interacción con ella a través de un ORM como JPA.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String patente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Marca marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = true)
    private String cilindrada;

    @Column(nullable = true)
    private String chasis;

    @Column(nullable = true)
    private Integer kilometraje;

    @Column(name = "alta_moto")
    private LocalDate altaMoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    // Getters y setters
}
