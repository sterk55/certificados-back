package com.iess.certificados.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iess.certificados.repository.model.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class RepositoryPacienteImpl implements IRepositoryPaciente{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crear(Paciente paciente) {
        // TODO Auto-generated method stub
        this.entityManager.persist(paciente);
    }

    @Override
    public List<Paciente> buscarPorCedula(String cedula) {
        // TODO Auto-generated method stub
            TypedQuery<Paciente>mQuery= this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula=:cedula", Paciente.class);
            mQuery.setParameter("cedula", cedula);
            if(mQuery.getResultList().isEmpty()){
                return null;
            }
    
            return mQuery.getResultList();

    }

    @Override
    public void actualizar(Paciente paciente) {
        // TODO Auto-generated method stub
        this.entityManager.merge(paciente);
    }

    @Override
    public void eliminarPorCedula(String cedula) {
       // TypedQuery<Paciente> mQuery = this.entityManager.createQuery("DELETE p FROM Paciente p WHERE cedula = :cedula", Paciente.class);
       // mQuery.setParameter("cedula", cedula);
        Paciente pacienteBorrar = this.buscarPorCedula(cedula).get(0);
        this.entityManager.remove(pacienteBorrar);

    }

    @Override
    public List<Paciente> listarPacientes() {
        TypedQuery<Paciente> mQuery = this.entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class);

        return mQuery.getResultList();
    }

	@Override
	public List<Paciente> buscarPorApellido(String apellido) {
		TypedQuery<Paciente> mQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE POSITION(UPPER(:apellido) in UPPER(p.apellido))>0", Paciente.class);
        
        mQuery.setParameter("apellido", apellido);
        if(mQuery.getResultList().isEmpty()){
            return null;
        }

        return mQuery.getResultList();
	}
    
}
