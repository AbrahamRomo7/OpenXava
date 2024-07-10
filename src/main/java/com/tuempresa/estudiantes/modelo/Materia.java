package com.tuempresa.estudiantes.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Materia {
    @Id
    @Hidden
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;

    @Column(length=70)
    private String nombreMateria;

    @ManyToOne
    @DescriptionsList(descriptionProperties="nombreAula")
    private Aula aula;

    @ManyToOne
    @DescriptionsList(descriptionProperties="nombreProfesor")
    private Profesor profesor;
    
    @Column(length=80)
    private String horario;
}
