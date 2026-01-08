/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dispositivos;
import Model.Pecas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author gabri
 */
public class EstoqueDAO {
    private EntityManagerFactory emf;
    
    public EstoqueDAO(){
        emf = Persistence.createEntityManagerFactory("PCMasterRacePU");
    }
    
    public void salvarPeca(Pecas peca){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            if (peca.getID() == 0){
                em.persist(peca);
            } else {
                em.merge(peca);
            }
            em.getTransaction().commit();
            
        } catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void salvarDispositivo(Dispositivos dispositivo){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            if (dispositivo.getID() == 0){
                em.persist(dispositivo);
            } else {
                em.merge(dispositivo);
            }
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
        
    }
    
    public List<Pecas> listarPecas(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT p FROM Pecas p", Pecas.class).getResultList();
        
        } finally {
            em.close();
        }
    }
    
    public List<Dispositivos> listarDispositivos(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT d FROM Dispositivos d", Dispositivos.class).getResultList();
        } finally {
            em.close();
        }
    }

    public EntityManager getEntityManager() {
        
        return emf.createEntityManager();
    }

    
    
}
