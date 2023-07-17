package com.iess.certificados.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cie10")
public class Cie10 {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cie10")
    @Column(name = "cie_id")
    private int id;

    @Column(name = "cie_codigo")
    private String codigo;

    @Column(name = "cie_descripcion")
    private String descripcion;
    



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
