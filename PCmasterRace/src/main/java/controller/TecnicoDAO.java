/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author superbi
 */
public class TecnicoDAO {
    public void salvar(Tecnico tecnico) {

        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(tecnico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); 
            throw e;
        } finally {
            em.close(); 
        }
    }
    
    public List<Tecnico> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Tecnico> tecnicos = null;
        try {
            // JPQL: Busca todos os objetos da classe Tecnico
            TypedQuery<Tecnico> query = em.createQuery("SELECT c FROM Tecnico c", Tecnico.class);
            tecnicos = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar tecnicos: " + e.getMessage());
        } finally {
            em.close();
        }
        return tecnicos;
    }
}
