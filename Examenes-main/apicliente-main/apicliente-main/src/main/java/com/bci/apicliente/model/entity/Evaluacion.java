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
@Table(name = "evaluacion")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacion")
    private int idEvaluacion;

    @Column(name = "idSolicitud")
    private int idSolicitud;

    @Column(name = "propuestaSolucion")
    private String propuestaSolucion;

    @Column(name = "estimacionTiempo")
    private String estimacionTiempo;

    @Column(name = "numeroProgramadores")
    private int numeroProgramadores;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "idAnexo")
    private int idAnexo;

    @Column(name = "idEmpleado")
    private int idEmpleado;

    @Column(name = "fechaEvaluacion")
    private Date fechaEvaluacion;

    @Column(name = "estado")
    private int estado;
}
