package com.iess.certificados.service;

import java.util.List;

import com.iess.certificados.repository.model.Cie10;

public interface ICieService {
    
    public void crear(Cie10 cie10);

    public Cie10 buscarPorCodigo(String codigo);

    public void actualizar(Cie10 cie10);

    public List<Cie10> listaCie();

    public List<Cie10> buscarPorDescripcion(String descripcion);
}
