package com.iess.certificados.service;


import java.util.List;

import com.iess.certificados.repository.model.Paciente;

public interface IPacienteService {
    
    public void crear(Paciente paciente);

    public List<Paciente> buscarPorCedula(String cedula);

    public void actualizar(Paciente paciente);

    public void eliminarPorCedula(String cedula);

    public List<Paciente> listarPacientes();

    public List<Paciente> buscarPorApellido(String apellido);

  
}
