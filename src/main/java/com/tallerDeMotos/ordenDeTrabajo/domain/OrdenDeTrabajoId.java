package com.tallerDeMotos.ordenDeTrabajo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Embeddable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDeTrabajoId {
    private Long id;
}
