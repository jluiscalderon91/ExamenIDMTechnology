package com.bci.apicliente.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ResponseSolicitud {
    private String codigo;
    private String mensaje;
    private int codigoSolicitud;

    public ResponseSolicitud() {
    }
}
