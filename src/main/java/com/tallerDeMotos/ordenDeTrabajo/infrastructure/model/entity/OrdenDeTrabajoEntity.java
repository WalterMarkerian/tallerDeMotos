package com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity;

import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "ordenes_de_trabajo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDeTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_de_trabajo_id")
    private Long ordenDeTrabajoId;
    @Column(nullable = false)
    private Integer items;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Double monto;
    @Column(name = "alta_orden", nullable = false)
    private LocalDate altaOrden;
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motocicleta_id", nullable = false)
    private MotocicletaEntity motocicleta;
}
