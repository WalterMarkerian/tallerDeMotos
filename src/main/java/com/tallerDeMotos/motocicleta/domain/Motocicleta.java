package com.tallerDeMotos.motocicleta.domain;

import com.tallerDeMotos.motocicleta.domain.enums.Marca;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajo;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Motocicleta {
    //Representa el modelo de dominio, el cual encapsula la lógica empresarial
    //y no depende de ninguna tecnología o framework específico (como JPA). Este es el "core" de tu aplicación.
    private Long id;
    private String patente;
    private Marca marca;
    private String modelo;
    private String cilindrada;
    private String chasis;
    private Integer kilometraje;
    private LocalDate altaMoto;
    private List<OrdenDeTrabajo> ordenDeTrabajo;

    // Getters y setters
}
