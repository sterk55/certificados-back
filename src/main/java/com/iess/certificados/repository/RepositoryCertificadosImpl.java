package com.iess.certificados.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iess.certificados.repository.model.Certificados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositoryCertificadosImpl implements IRepositoryCertificados{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void crear(Certificados certificados) {
        // TODO Auto-generated method stub
        this.entityManager.persist(certificados);
    }

    @Override
    public Certificados buscar(int id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Certificados.class, id);
    }

    @Override
    public void actualizar(Certificados certificados) {
        // TODO Auto-generated method stub
        this.entityManager.merge(certificados);
    }

    @Override
    public void eliminar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Certificados> listarCertificados() {
        TypedQuery<Certificados> mQuery = this.entityManager.createQuery("SELECT c FROM Certificados c", Certificados.class);

        return mQuery.getResultList();
    }

    @Override
    public List<Certificados> buscarPorCedula(String cedulaPaciente) {
        // TODO Auto-generated method stub
        TypedQuery<Certificados> mQuery = this.entityManager.createQuery("SELECT c FROM Certificados c WHERE c.cedulaPaciente = :cedulaPaciente", Certificados.class);
        mQuery.setParameter("cedulaPaciente", cedulaPaciente);
        if(mQuery.getResultList().isEmpty()){
            return null;
        }
        
        return mQuery.getResultList();
    }

    @Override
    public List<Certificados> buscarPorFecha(LocalDate fechaGeneracion) {
        // TODO Auto-generated method stub
        TypedQuery<Certificados> mQuery = this.entityManager.createQuery("SELECT c FROM Certificados c WHERE c.fechaGeneracion = :fechaGeneracion", Certificados.class);
        mQuery.setParameter("fechaGeneracion", fechaGeneracion);
        if(mQuery.getResultList().isEmpty()){
            return null;
        }

        return mQuery.getResultList();
    }

    @Override
    public List<Certificados> buscarPorCedulaD(String cedulaDoctor) {
        TypedQuery<Certificados> mQuery = this.entityManager.createQuery("SELECT c FROM Certificados c WHERE c.cedulaDoctor = :cedulaDoctor", Certificados.class);
        mQuery.setParameter("cedulaDoctor", cedulaDoctor);
        if(mQuery.getResultList().isEmpty()){
            return null;
        }
        
        return mQuery.getResultList();
    }
    
}
