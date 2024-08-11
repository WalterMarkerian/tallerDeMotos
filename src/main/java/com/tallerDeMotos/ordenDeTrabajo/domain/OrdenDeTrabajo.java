package com.tallerDeMotos.ordenDeTrabajo.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrdenDeTrabajo {
    private Long id;
    private Integer items;
    private String descripcion;
    private Double monto;
    private Timestamp altaOrden;
    // Getters y setters
}