package com.iess.certificados.service;

import java.util.List;

import com.iess.certificados.repository.model.Doctor;

public interface IDoctorService {
    
    public void crear(Doctor doctor);

    public List<Doctor> buscarPorCedula(String cedula);

    public void actualizar(Doctor doctor);

    public List<Doctor> listarDoctores();

    public void eliminarPorCedula(String cedula);

    public Doctor loginAprobado(String cedula, String contraseña);

}
