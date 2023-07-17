package com.iess.certificados.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iess.certificados.repository.IRepositoryPaciente;
import com.iess.certificados.repository.model.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IRepositoryPaciente iRepositoryPaciente;

    @Override
    public void crear(Paciente paciente) {
        // TODO Auto-generated method stub
        this.iRepositoryPaciente.crear(paciente);
    }

    @Override
    public List<Paciente> buscarPorCedula(String cedula) {
        if (this.iRepositoryPaciente.buscarPorCedula(cedula) == null) {
            return null;
        }

        return this.iRepositoryPaciente.buscarPorCedula(cedula);
    }

    @Override
    public void actualizar(Paciente paciente) {
        // TODO Auto-generated method stub
        this.iRepositoryPaciente.actualizar(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        List<Paciente> listaPac = this.iRepositoryPaciente.listarPacientes();
        listaPac.sort(Comparator.comparing(Paciente::getApellido).reversed());
        // listaPac.stream().sorted(Comparator.comparing(Paciente::getDireccion).reversed());

        return listaPac;
    }

    @Override
    public List<Paciente> buscarPorApellido(String apellido) {
        if (this.iRepositoryPaciente.buscarPorApellido(apellido) == null) {
            return null;
        }

        return this.iRepositoryPaciente.buscarPorApellido(apellido);

    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.iRepositoryPaciente.eliminarPorCedula(cedula);
    }

}
