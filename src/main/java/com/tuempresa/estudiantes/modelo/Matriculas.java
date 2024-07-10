package com.tuempresa.estudiantes.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Matriculas {
    @Id
    @Hidden
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String idMatricula;

    @ManyToOne(fetch=FetchType.LAZY, optional=true)
    @DescriptionsList
    private Estudiante est;

    @ManyToOne
    @DescriptionsList(descriptionProperties="nombreMateria")
    private Materia materia;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList(descriptionProperties="nombreProfesor")
    @ReadOnly
    private Profesor profesor;

    @PrePersist
    @PreUpdate
    private void asignarProfesor() {
        if (materia != null) {
            this.profesor = materia.getProfesor();
        }
    }
}

