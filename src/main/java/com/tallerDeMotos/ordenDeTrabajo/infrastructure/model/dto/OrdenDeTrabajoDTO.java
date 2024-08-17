package com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallerDeMotos.motocicleta.domain.MotocicletaId;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.ordenDeTrabajo.domain.OrdenDeTrabajoId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrdenDeTrabajoDTO {
    @Schema(description = "Identificador de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "id")
    OrdenDeTrabajoId ordenDeTrabajoId;

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
    LocalDate altaOrden;

    @Schema(description = "Identificador de la motocicleta asociada a la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty(value = "motocicletaId", required = true)
    @NotNull(message = "El identificador de la motocicleta es requerido.")
    MotocicletaId motocicletaId;

}
