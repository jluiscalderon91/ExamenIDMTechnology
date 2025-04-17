package com.bci.apicliente.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private int codigoCliente;
    @Schema(
            description = "fecha de nacimiento del cliente",
            name = "nombres",
            type = "string",
            example = "Pedro")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;
    @Schema(
            description = "Apellido paterno del cliente",
            name = "appaterno",
            type = "string",
            example = "Perez")
    @NotBlank(message = "El apellido paterno es obligatorio")
    private String appaterno;
    @Schema(
            description = "Apellido materno del cliente",
            name = "apmaterno",
            type = "string",
            example = "Rojas")
    @NotBlank(message = "El apellido materno es obligatorio")
    private String apmaterno;
    @Schema(
            description = "Fecha de nacimiento del cliente",
            name = "nacimiento",
            type = "string",
            example = "20/04/1991")
    @NotBlank(message = "La fecha de nacimiento es obligatorio")
    private String nacimiento;
    @Schema(
            description = "Sexo del cliente ",
            name = "genero",
            type = "string",
            example = "M", defaultValue = "F = Femenino ; M = Masculino")
    @NotBlank(message = "El género es obligatorio")
    private String genero;
    @Schema(
            description = "Correo del cliente",
            name = "correo",
            type = "string",
            example = "jluis@gmail.com")
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;
    @Schema(
            description = "Teléfono del cliente",
            name = "telefono",
            type = "string",
            example = "987123456")
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    @Schema(
            description = "Estado del registro",
            name = "estado",
            type = "string",
            example = "1", defaultValue = "1 = Activo ; 0 = Inactivo")
    @NotBlank(message = "El género es obligatorio")
    private String estado;
}
