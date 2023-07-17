package com.iess.certificados.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_doctor")
    @Column(name = "doc_id")
    private int id;

    @Column(name = "doc_nombre")
    private String nombre;

    @Column(name = "doc_apellido")
    private String apellido;

    @Column(name = "doc_cedula")
    private String cedula;

    @Column(name = "doc_correo")
    private String correo;

    @Column(name = "doc_telefono")
    private String telefono;

    @Column(name = "doc_direccion")
    private String direccion;

    @Column(name = "doc_direccion_detallada")
    private String direccionDetallada;

    @Column(name = "doc_profesion")
    private String profesion;

    @Column(name = "doc_contraseña")
    private String contraseña;

    @Column(name = "doc_admin")
    private boolean admin;

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



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


    public boolean isAdmin() {
        return this.admin;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


    public String getDireccionDetallada() {
        return this.direccionDetallada;
    }

    public void setDireccionDetallada(String direccionDetallada) {
        this.direccionDetallada = direccionDetallada;
    }

}
