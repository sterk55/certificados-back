package com.iess.certificados.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iess.certificados.repository.IRepositoryDoctor;
import com.iess.certificados.repository.model.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService{

    @Autowired
    private IRepositoryDoctor repositoryDoctor;

    @Override
    public void crear(Doctor doctor) {
        // TODO Auto-generated method stub
        this.repositoryDoctor.crear(doctor);
    }

    @Override
    public List<Doctor> buscarPorCedula(String cedula) {
        // TODO Auto-generated method stub
        return this.repositoryDoctor.buscarPorCedula(cedula);
    }

    @Override
    public void actualizar(Doctor doctor) {
        // TODO Auto-generated method stub
        this.repositoryDoctor.actualizar(doctor);
    }

	@Override
	public List<Doctor> listarDoctores() {
		List<Doctor> listaDoc = this.repositoryDoctor.listarDoctores();
        listaDoc.sort(Comparator.comparing(Doctor::getApellido).reversed());

        return listaDoc;
	}

    @Override
    public void eliminarPorCedula(String cedula) {
      this.repositoryDoctor.eliminarPorCedula(cedula);
    }

    @Override
    public Doctor loginAprobado(String cedula, String contraseña) {
      return this.repositoryDoctor.loginAprobado(cedula, contraseña);
    }
    
}
