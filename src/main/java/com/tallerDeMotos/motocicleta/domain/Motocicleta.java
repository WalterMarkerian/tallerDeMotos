package com.tallerDeMotos.motocicleta.domain;

import com.tallerDeMotos.cliente.domain.Cliente;
import com.tallerDeMotos.motocicleta.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
public class Motocicleta {
    private Long motocicletaId;
    private String patente;
    private Marca marca;
    private String modelo;
    private String cilindrada;
    private String chasis;
    private Integer kilometraje;
    private LocalDate altaMoto;
    private List<OrdenDeTrabajo> ordenesDeTrabajo;
    @Setter
    private Cliente cliente;

}
