package com.bci.apicliente.bean;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class ResponseConsultaBean {
    private String codigo;
    private String mensaje;
    private Object data;

    public ResponseConsultaBean() {
    }
}
