package com.iess.certificados.repository;

import java.util.List;

import com.iess.certificados.repository.model.Doctor;

public interface IRepositoryDoctor {
    
    public void crear(Doctor doctor);

    public List<Doctor> buscarPorCedula(String cedula);

    public void actualizar(Doctor doctor);

    public void eliminarPorCedula(String cedula);

    public List<Doctor> listarDoctores();

    public Doctor loginAprobado(String cedula, String pass);
}
