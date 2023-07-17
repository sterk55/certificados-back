package com.iess.certificados.repository;

import java.util.List;

import com.iess.certificados.repository.model.Cie10;

public interface IRepositoryCie10 {
    
    public void crear(Cie10 cie10);

    public Cie10 buscarPorCodigo(String codigo);

    public void actualizar(Cie10 cie10);

    public void eliminar(int codigo);

    public List<Cie10> listarCie();

    public List<Cie10> buscarPorDescripcion(String descripcion);
}
