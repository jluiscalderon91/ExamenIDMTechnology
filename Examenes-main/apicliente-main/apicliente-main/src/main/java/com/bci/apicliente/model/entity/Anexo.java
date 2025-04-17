package com.bci.apicliente.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anexos")
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnexo")
    private int idAnexo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "guid")
    private String guid;

    @Column(name = "estado")
    private int estado;

    @OneToOne
    @JoinColumn(name="anexos")
    private Solicitud solicitud;
}
