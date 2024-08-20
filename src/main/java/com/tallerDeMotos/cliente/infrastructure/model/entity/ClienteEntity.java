package com.tallerDeMotos.cliente.infrastructure.model.entity;

import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long clienteId;
    private Long dni;
    private LocalDate fechaNacimiento;
    private LocalDate altaCliente;
    private String nombre;
    private String apellido;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;
    private String telefono;
    private String domicilio;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<MotocicletaEntity> motocicletas = new ArrayList<>();

    public void addMotocicleta(MotocicletaEntity motocicleta) {
        motocicletas.add(motocicleta);
        motocicleta.setCliente(this);
    }

    public void removeMotocicleta(MotocicletaEntity motocicleta) {
        motocicletas.remove(motocicleta);
        motocicleta.setCliente(null);
    }
}