package com.tallerDeMotos.cliente.domain;

import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
//encapsula la lógica de negocio
//Es común en una arquitectura hexagonal tener esta clase para separar la
//lógica de negocio de los detalles de la infraestructura.
public class Cliente {
    private Long id;
    private Long dni;
    private LocalDate fechaNacimiento;
    private LocalDate altaCliente;
    private String nombre;
    private String apellido;
    private Genero genero;
    private String telefono;
    private String domicilio;
    private List<Motocicleta> motocicletas;

    // Getters y setters
}