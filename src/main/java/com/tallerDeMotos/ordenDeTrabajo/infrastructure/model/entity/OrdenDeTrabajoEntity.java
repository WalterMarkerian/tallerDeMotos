package com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity;

import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "orden_de_trabajo_id"))
    })
    private OrdenDeTrabajoId ordenDeTrabajoId;
    @Column(nullable = false)
    private Integer items;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "alta_orden", nullable = false)
    private LocalDate altaOrden;

    @ManyToOne
    @JoinColumn(name = "motocicleta_id")
    private MotocicletaEntity motocicleta;

}
