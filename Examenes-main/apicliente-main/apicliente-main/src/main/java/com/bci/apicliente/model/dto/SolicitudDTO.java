package com.bci.apicliente.model.dto;

import com.bci.apicliente.model.entity.Anexo;
import com.bci.apicliente.model.entity.Solicitante;
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
public class SolicitudDTO {
    private int idSolicitud;
    private String nombre;
    private String descripcion;
    private Anexo anexo;
    private Solicitante solicitante;
    private String estado;
}
