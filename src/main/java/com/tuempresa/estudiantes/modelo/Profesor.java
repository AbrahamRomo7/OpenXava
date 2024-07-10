package com.tuempresa.estudiantes.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Profesor {
    @Id
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=10)
    private String cedProfesor;

    @Column(length=70)
    private String nombreProfesor;

    @Column(length=70)
    private String direccionProfesor;

    @File
    @Column(length=50)
    private String fotos;

    @Hidden
    @Column(length=70)
    private String descripcion;
}
