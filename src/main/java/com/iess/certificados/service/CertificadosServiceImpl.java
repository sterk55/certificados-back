package com.iess.certificados.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iess.certificados.repository.IRepositoryCertificados;
import com.iess.certificados.repository.model.Certificados;

@Service
public class CertificadosServiceImpl implements ICertificadosService{

    @Autowired
    private IRepositoryCertificados repositoryCertificados;

    @Override
    public void crear(Certificados certificados) {
        // TODO Auto-generated method stub
        this.repositoryCertificados.crear(certificados);
    }

    @Override
    public Certificados buscar(int id) {
        // TODO Auto-generated method stub
        return this.repositoryCertificados.buscar(id);
    }

    @Override
    public void actualizar(Certificados certificados) {
        // TODO Auto-generated method stub
        this.repositoryCertificados.actualizar(certificados);
    }

    @Override
    public List<Certificados> listarCertificados() {
        List<Certificados> listaCer = this.repositoryCertificados.listarCertificados();
        listaCer.sort(Comparator.comparing(Certificados::getFechaGeneracion).reversed());
        
        return listaCer;

    }

    @Override
    public List<Certificados> buscarPorCedula(String cedulaPaciente) {
        if(this.repositoryCertificados.buscarPorCedula(cedulaPaciente) == null){
            return null;
        }
        return this.repositoryCertificados.buscarPorCedula(cedulaPaciente);
    }

    @Override
    public List<Certificados> buscarPorFecha(LocalDate fechaGeneracion) {
        if(this.repositoryCertificados.buscarPorFecha(fechaGeneracion)==null){
            return null;
        }

        return this.repositoryCertificados.buscarPorFecha(fechaGeneracion);

    }

    @Override
    public List<Certificados> buscarPorCedulaD(String cedulaDoctor) {
        if(this.repositoryCertificados.buscarPorCedulaD(cedulaDoctor) == null){
            return null;
        }
        return this.repositoryCertificados.buscarPorCedulaD(cedulaDoctor);
    }
    
}
