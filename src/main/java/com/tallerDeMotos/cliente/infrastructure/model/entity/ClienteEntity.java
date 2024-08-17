package com.tallerDeMotos.cliente.infrastructure.model.entity;

import com.tallerDeMotos.cliente.domain.ClienteId;
import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.cliente.infrastructure.converter.ClienteIdConverter;
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
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "cliente_id"))
    })
    private ClienteId clienteId;
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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MotocicletaEntity> motocicletas = new ArrayList<>();
}