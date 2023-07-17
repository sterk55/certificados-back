package com.iess.certificados.repository;

import java.util.List;

import com.iess.certificados.repository.model.Paciente;

public interface IRepositoryPaciente {
    
    public void crear(Paciente paciente);

    public List<Paciente> buscarPorCedula(String cedula);

    public void actualizar(Paciente paciente);

    public void eliminarPorCedula(String cedula);

    public List<Paciente> listarPacientes();

    public List<Paciente> buscarPorApellido(String apellido);


}
