package com.iess.certificados.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iess.certificados.repository.model.Cie10;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RepositoryCieImpl implements IRepositoryCie10{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crear(Cie10 cie10) {
        // TODO Auto-generated method stub
        this.entityManager.persist(cie10);
    }

    @Override
    public Cie10 buscarPorCodigo(String codigo) {
        // TODO Auto-generated method stub
		TypedQuery<Cie10>myQuery=this.entityManager.createQuery("SELECT d FROM Cie10 d WHERE d.codigo=:codigo",Cie10.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
    }

    @Override
    public void actualizar(Cie10 cie10) {
        // TODO Auto-generated method stub
    this.entityManager.merge(cie10);
    }

    @Override
    public void eliminar(int codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Cie10> listarCie() {
    TypedQuery<Cie10> mQuery = this.entityManager.createQuery("SELECT c FROM Cie10 c", Cie10.class);

    return mQuery.getResultList();

    }

    @Override
    public List<Cie10> buscarPorDescripcion(String descripcion) {
       TypedQuery<Cie10> mQuery = this.entityManager.createQuery("SELECT c FROM Cie10 c WHERE POSITION(UPPER(:descripcion) in UPPER(c.descripcion))>0", Cie10.class);
       mQuery.setParameter("descripcion", descripcion);
       if(mQuery.getResultList().isEmpty()){
        return null;
       }

       return mQuery.getResultList();
    }
    
}
