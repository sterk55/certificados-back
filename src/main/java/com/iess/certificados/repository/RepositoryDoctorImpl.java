package com.iess.certificados.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iess.certificados.repository.model.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositoryDoctorImpl implements IRepositoryDoctor{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void crear(Doctor doctor) {
        // TODO Auto-generated method stub
        this.entityManager.persist(doctor);
    }

    @Override
    public List<Doctor> buscarPorCedula(String cedula) {
        // TODO Auto-generated method stub
        TypedQuery<Doctor>myQuery=this.entityManager.createQuery("select d from Doctor d where d.cedula=:cedula",Doctor.class);
		myQuery.setParameter("cedula", cedula);
		
        if(myQuery.getResultList().isEmpty()){
            return null;
        }
        return myQuery.getResultList();
        }

    @Override
    public void actualizar(Doctor doctor) {
        // TODO Auto-generated method stub
        this.entityManager.merge(doctor);   
    }

    @Override
    public void eliminarPorCedula(String cedula) {
       Doctor doctorBorrar = this.buscarPorCedula(cedula).get(0);
        this.entityManager.remove(doctorBorrar);
    }

	@Override
	public List<Doctor> listarDoctores() {
		TypedQuery<Doctor> mQuery = this.entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class);

        return mQuery.getResultList();
	}

    @Override
    public Doctor loginAprobado(String cedula, String contraseña) {
      
        TypedQuery<Doctor> mQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula=:cedula AND d.contraseña=:contraseña", Doctor.class);
        mQuery.setParameter("cedula", cedula);
        mQuery.setParameter("contraseña", contraseña);
        
        if(mQuery.getResultList().isEmpty()){
            return null;
        }

        return mQuery.getSingleResult();
    }

    
    
}
