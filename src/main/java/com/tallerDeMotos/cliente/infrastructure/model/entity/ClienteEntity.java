package com.tallerDeMotos.cliente.infrastructure.model.entity;

import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor  // Este es el constructor por defecto
@AllArgsConstructor // Este es el constructor con todos los parámetros
//tabla en la base de datos
//diseñada para interactuar directamente con la base de datos.
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "cliente")
    private List<MotocicletaEntity> motocicletas;

    // Getters y setters
}