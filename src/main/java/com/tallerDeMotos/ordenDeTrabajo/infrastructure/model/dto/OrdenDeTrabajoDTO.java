package com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class OrdenDeTrabajoDTO {
    // Este Data Transfer Object (DTO) se utiliza para transferir datos entre la capa de presentación (o API)
    // y el resto del sistema. Su principal función es evitar que las entidades del dominio se expongan directamente
    // al exterior y para facilitar la validación y documentación con anotaciones como @Schema y @JsonProperty.

    @Schema(description = "Identificador de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "123L")
    @JsonProperty(value = "id")
    Long id;

    @Schema(description = "Número de items en la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @JsonProperty(value = "items", required = true)
    @NotNull(message = "El número de items es requerido.")
    Integer items;

    @Schema(description = "Descripción de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cambio de aceite")
    @JsonProperty(value = "descripcion", required = true)
    @NotNull(message = "La descripción es requerida.")
    String descripcion;

    @Schema(description = "Monto de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "150.75")
    @JsonProperty(value = "monto", required = true)
    @NotNull(message = "El monto es requerido.")
    Double monto;

    @Schema(description = "Fecha de alta de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-08-10T14:30:00")
    @JsonProperty(value = "altaOrden", required = true)
    @NotNull(message = "La fecha de alta es requerida.")
    Timestamp altaOrden;

    @Schema(description = "Motocicleta asociada a la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "motocicleta", required = true)
    @NotNull(message = "La motocicleta es requerida.")
    MotocicletaDTO motocicleta; // Suponiendo que tienes un DTO para Motocicleta

    // Getters y setters
}
