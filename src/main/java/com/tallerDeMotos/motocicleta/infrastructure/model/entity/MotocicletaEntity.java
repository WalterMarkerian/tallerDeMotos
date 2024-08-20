package com.tallerDeMotos.motocicleta.infrastructure.model.entity;

import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallerDeMotos.motocicleta.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "motocicletas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotocicletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motocicleta_id")
    private Long motocicletaId;

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

    // Método para establecer la relación bidireccional con el cliente
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "motocicleta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenDeTrabajoEntity> ordenesDeTrabajo = new ArrayList<>();

    public void addOrdenDeTrabajo(OrdenDeTrabajoEntity ordenDeTrabajo) {
        ordenesDeTrabajo.add(ordenDeTrabajo);
        ordenDeTrabajo.setMotocicleta(this);
    }

    public void removeOrdenDeTrabajo(OrdenDeTrabajoEntity ordenDeTrabajo) {
        ordenesDeTrabajo.remove(ordenDeTrabajo);
        ordenDeTrabajo.setMotocicleta(null);
    }
}