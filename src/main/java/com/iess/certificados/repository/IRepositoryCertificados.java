package com.iess.certificados.repository;

import java.time.LocalDate;
import java.util.List;


import com.iess.certificados.repository.model.Certificados;

public interface IRepositoryCertificados {
    
    public void crear(Certificados certificados);
    
    public Certificados buscar(int id);

    public void actualizar(Certificados certificados);

    public void eliminar();

    public List<Certificados> listarCertificados();

    public List<Certificados> buscarPorCedula(String cedulaPaciente);

    public List<Certificados> buscarPorCedulaD(String cedulaDoctor);

    public List<Certificados> buscarPorFecha(LocalDate fechaGeneracion );

}
