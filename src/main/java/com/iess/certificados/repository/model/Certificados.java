package com.iess.certificados.repository.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificados")
public class Certificados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_certificados")
    @Column(name = "cer_id")
    private int id;

    @Column(name = "cer_cedula_paciente" )
    private String cedulaPaciente;

    @Column(name = "cer_fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "cer_fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "cer_dias_validos")
    private long diasValidos ;

    @Column(name = "cer_fecha_generacion")
    private LocalDate fechaGeneracion;

    @Column(name = "cer_cedula_doctor")
    private String cedulaDoctor;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedulaPaciente() {
        return this.cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate FechaFin) {
        this.fechaFin = FechaFin;
    }


    public long getDiasValidos() {
        return this.diasValidos;
    }

    public void setDiasValidos(long diasValidos) {
        this.diasValidos = diasValidos;
    }
    

    public LocalDate getFechaGeneracion() {
        return this.fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }


    public String getCedulaDoctor() {
        return this.cedulaDoctor;
    }

    public void setCedulaDoctor(String cedulaDoctor) {
        this.cedulaDoctor = cedulaDoctor;
    }


}
