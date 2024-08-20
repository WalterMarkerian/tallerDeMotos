package com.tallerDeMotos.cliente.domain;

import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private Long clienteId;
    private Long dni;
    private LocalDate fechaNacimiento;
    private LocalDate altaCliente;
    private String nombre;
    private String apellido;
    private Genero genero;
    private String telefono;
    private String domicilio;
    private List<Motocicleta> motocicletas = new ArrayList<>();

    // Método para agregar una motocicleta a la lista y establecer la relación bidireccional
    public void addMotocicleta(Motocicleta motocicleta) {
        motocicletas.add(motocicleta);
        motocicleta.setCliente(this);
    }

    // Método para eliminar una motocicleta de la lista y romper la relación bidireccional
    public void removeMotocicleta(Motocicleta motocicleta) {
        motocicletas.remove(motocicleta);
        motocicleta.setCliente(null);
    }
}