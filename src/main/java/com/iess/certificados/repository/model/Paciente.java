package com.iess.certificados.repository.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    @Column(name = "pac_id")
    private int id;

    @Column(name = "pac_nombre")
    private String nombre;

    @Column(name = "pac_apellido")
    private String apellido;

    @Column(name = "pac_cedula")
    private String cedula;

    @Column(name = "pac_direccion")
    private String direccion;

    @Column(name = "pac_telefono")
    private String telefono;

    @Column(name = "pac_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "pac_codigo")
    private String codigoSeguro;
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodigoSeguro() {
        return this.codigoSeguro;
    }

    public void setCodigoSeguro(String codigoSeguro) {
        this.codigoSeguro = codigoSeguro;
    }


}

