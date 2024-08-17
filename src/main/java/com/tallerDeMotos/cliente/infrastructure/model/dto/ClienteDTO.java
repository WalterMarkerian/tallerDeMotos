package com.tallerDeMotos.cliente.infrastructure.model.dto;

import com.tallerDeMotos.cliente.domain.ClienteId;
import com.tallerDeMotos.cliente.domain.enums.Genero;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ClienteDTO {

    @Schema(description = "Identificador del cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El id es requerido.")
    ClienteId clienteId;

    @Schema(description = "Dni del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234567890")
    @NotNull(message = "El DNI es requerido.")
    Long dni;

    @Schema(description = "Fecha de nacimiento del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1990-05-15")
    @NotNull(message = "La fecha de nacimiento es requerida.")
    LocalDate fechaNacimiento;

    @Schema(description = "Fecha de alta del cliente", example = "2024-08-10")
    LocalDate altaCliente;

    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan")
    @NotBlank(message = "El nombre es requerido.")
    String nombre;

    @Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "De Los Palotes")
    @NotBlank(message = "El apellido es requerido.")
    String apellido;

    @Schema(description = "Género del cliente", example = "MASCULINO")
    @NotNull(message = "El género es requerido.")
    Genero genero;

    @Schema(description = "Teléfono del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "+54 9 11 1234 4321")
    @NotBlank(message = "El teléfono es requerido.")
    String telefono;

    @Schema(description = "Domicilio del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle Falsa 123")
    @NotBlank(message = "El domicilio es requerido.")
    String domicilio;

    @Schema(description = "Lista de motocicletas del cliente", example = "[{ \"id\": 1, \"marca\": \"Yamaha\", \"modelo\": \"MT-09\" }]")
    @NotNull(message = "La lista de motocicletas no puede ser nula.")
    List<MotocicletaDTO> motocicletas;

}
