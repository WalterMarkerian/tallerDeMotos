package com.tallerDeMotos.ordenDeTrabajo.domain;

import com.tallerDeMotos.motocicleta.domain.Motocicleta;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class OrdenDeTrabajo {
    private Long ordenDeTrabajoId;
    private Integer items;
    private String descripcion;
    private Double monto;
    private LocalDate altaOrden;
    @Setter
    private Motocicleta motocicleta;

}