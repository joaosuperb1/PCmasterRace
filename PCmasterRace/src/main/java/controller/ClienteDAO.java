/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author superbi
 */
public class ClienteDAO {
    
    public void salvar(Cliente cliente) {
        // 1. Pede um gerente NOVO para a fábrica estática
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // Desfaz se der erro
            throw e;
        } finally {
            // 2. Fecha este gerente específico, mas a Fábrica continua viva lá no JPAUtil
            em.close(); 
        }
    }
}