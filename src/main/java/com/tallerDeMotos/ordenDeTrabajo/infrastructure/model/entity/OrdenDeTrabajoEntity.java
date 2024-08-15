package com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity;

import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "ordenes_de_trabajo")
@Data
public class OrdenDeTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer items;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "alta_orden", nullable = false)
    private LocalDate altaOrden;

    @ManyToOne
    @JoinColumn(name = "motocicleta_id", nullable = false)
    private MotocicletaEntity motocicleta;

}
