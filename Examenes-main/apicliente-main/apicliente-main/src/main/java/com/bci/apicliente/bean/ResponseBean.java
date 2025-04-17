package com.bci.apicliente.bean;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class ResponseBean {
    private String codigo;
    private String mensaje;
    private int codigoCliente;

    public ResponseBean() {
    }
}
