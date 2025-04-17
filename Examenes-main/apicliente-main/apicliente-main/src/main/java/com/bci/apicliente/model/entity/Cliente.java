package com.bci.apicliente.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocliente")
    private int codigoCliente;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "appaterno")
    private String appaterno;

    @Column(name = "apmaterno")
    private String apmaterno;

    @Column(name = "nacimiento")
    private Date nacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private String estado;

}
