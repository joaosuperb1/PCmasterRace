/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.Cliente;
import Model.Feedback;
import Model.User;
import controller.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author superbi
 */
public class FeedbackController {

    public FeedbackController() {
    }

    /**
     * Busca todos os feedbacks (para Gerentes e Técnicos).
     * @return 
     */
    public List<Feedback> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Feedback> lista = null;
        try {
            // JPQL corrigido: Busca o feedback e o cliente associado (sem atendimento)
            String jpql = "SELECT f FROM Feedback f JOIN FETCH f.cliente c";
            TypedQuery<Feedback> query = em.createQuery(jpql, Feedback.class);
            lista = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar feedbacks: " + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }

    /**
     * Busca feedbacks apenas do cliente logado.
     */
    public List<Feedback> listarPorCliente(int idCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Feedback> lista = null;
        try {
            // JPQL corrigido: Filtra direto pelo ID do cliente na tabela Feedback
            String jpql = "SELECT f FROM Feedback f WHERE f.cliente.id = :id";
            TypedQuery<Feedback> query = em.createQuery(jpql, Feedback.class);
            query.setParameter("id", idCliente);
            lista = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar seus feedbacks: " + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }
    
    public void salvar(Feedback feedback) {
        EntityManager em = JPAUtil.getEntityManager(); 
        try {
            em.getTransaction().begin();

            if (feedback.getId() == 0) {
                em.persist(feedback);
            } else {
                em.merge(feedback);
            }

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Feedback enviado com sucesso!");
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao salvar feedback: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}