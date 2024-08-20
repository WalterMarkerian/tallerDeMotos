package com.tallerDeMotos.ordenDeTrabajo.domain;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdenDeTrabajo {
//    private OrdenDeTrabajoId ordenDeTrabajoId;
    private Long ordenDeTrabajoId;

    private Integer items;
    private String descripcion;
    private Double monto;
    private LocalDate altaOrden;
    private Motocicleta motocicleta;

    // Método para establecer la relación bidireccional con el cliente
    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }
}