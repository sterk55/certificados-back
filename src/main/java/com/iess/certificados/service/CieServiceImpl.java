package com.iess.certificados.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iess.certificados.repository.IRepositoryCie10;
import com.iess.certificados.repository.model.Cie10;

@Service
public class CieServiceImpl implements ICieService{

    @Autowired
    private IRepositoryCie10 repositoryCie10;

    @Override
    public void crear(Cie10 cie10) {
        // TODO Auto-generated method stub
        this.repositoryCie10.crear(cie10);
    }

    @Override
    public Cie10 buscarPorCodigo(String codigo) {
        // TODO Auto-generated method stub
        return this.repositoryCie10.buscarPorCodigo(codigo);
    }

    @Override
    public void actualizar(Cie10 cie10) {
        // TODO Auto-generated method stub
        this.repositoryCie10.actualizar(cie10);
    }

    @Override
    public List<Cie10> listaCie() {
    List<Cie10> listaCie = this.repositoryCie10.listarCie();
    //listaCie.sort(Comparator.comparing(Cie10::getCodigo).reversed().reversed());
    return listaCie;

       
    
    }

    @Override
    public List<Cie10> buscarPorDescripcion(String descripcion) {
        if(this.repositoryCie10.buscarPorDescripcion(descripcion)==null){
            return null;
        }
        return this.repositoryCie10.buscarPorDescripcion(descripcion);
    }
    
}
