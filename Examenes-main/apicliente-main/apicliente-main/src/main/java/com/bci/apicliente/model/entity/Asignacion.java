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
@Table(name = "asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsignacion")
    private int idAsignacion;

    @Column(name = "idSolicitud")
    private int idSolicitud;

    @Column(name = "idEmpleado")
    private int idEmpleado;

    @Column(name = "fechaAsignacion")
    private String fechaAsignacion;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "estado")
    private int estado;
}
