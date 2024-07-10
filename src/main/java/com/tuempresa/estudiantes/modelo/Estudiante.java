package com.tuempresa.estudiantes.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Estudiante {
    @Id
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=10)
    private String cedEstudiante;

    @Column(length=70)
    private String nombreEstudiante;

    @Column(length=70)
    private String direccionEstudiante;

    @File
    @Column(length=50)
    private String fotos;

    @Hidden
    @Column(length=70)
    private String descripcion;

    // Método para actualizar la descripción
    private void actualizarDescripcion() {
        this.descripcion = this.cedEstudiante + " " + this.nombreEstudiante;
    }

    public void setCedEstudiante(String cedEstudiante) {
        this.cedEstudiante = cedEstudiante;
        actualizarDescripcion();
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        actualizarDescripcion();
    }
}
