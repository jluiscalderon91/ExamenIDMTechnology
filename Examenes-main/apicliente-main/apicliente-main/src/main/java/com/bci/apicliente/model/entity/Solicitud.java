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
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolicitud")
    private int idSolicitud;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaSolicitud")
    private Date fechaSolicitud;

    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "idSolicitante")
    private Solicitante solicitante;

    @JoinColumn(name = "idAnexo")
    @OneToOne(fetch = FetchType.LAZY)
    private Anexo anexo;
}
