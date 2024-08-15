package com.tallerDeMotos.ordenDeTrabajo.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdenDeTrabajo {
    private Long id;
    private Integer items;
    private String descripcion;
    private Double monto;
    private LocalDate altaOrden;
}