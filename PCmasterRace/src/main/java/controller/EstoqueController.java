/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

// Importações assumidas com base nos nomes das classes
import Model.Dispositivos;
import Model.Pecas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author superbi
 */
public class EstoqueController {

    public EstoqueController() {
        // Construtor vazio
    }
    
    // ========================================================================
    // --- MÉTODOS PARA DISPOSITIVOS ---
    // ========================================================================

    /**
     * Retorna a lista de Dispositivos direto do Banco de Dados.
     */
    public List<Dispositivos> listarDispositivos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Dispositivos> lista = null;
        try {
            TypedQuery<Dispositivos> query = em.createQuery("SELECT d FROM Dispositivos d", Dispositivos.class);
            lista = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dispositivos: " + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }

    /**
     * Salva ou Atualiza um dispositivo no banco.
     */
    public void salvarDispositivo(Dispositivos dispositivo) {
        // Validação simples
        if (dispositivo.getBrand() == null || dispositivo.getBrand().isEmpty() || 
            dispositivo.getModel() == null || dispositivo.getModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Marca e Modelo são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            
            if (dispositivo.getID() == 0) {
                // INSERT
                em.persist(dispositivo);
                JOptionPane.showMessageDialog(null, "Dispositivo salvo com sucesso!");
            } else {
                // UPDATE
                em.merge(dispositivo);
                JOptionPane.showMessageDialog(null, "Dispositivo atualizado com sucesso!");
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao salvar dispositivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
    }

    /**
     * Exclui um dispositivo do banco.
     */
    public void excluirDispositivo(Dispositivos dispositivo) {
        if (dispositivo == null) return;
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir o dispositivo: " + dispositivo.getModel() + "?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManager em = JPAUtil.getEntityManager();
            try {
                em.getTransaction().begin();
                Dispositivos d = em.find(Dispositivos.class, dispositivo.getID());
                if (d != null) {
                    em.remove(d);
                    JOptionPane.showMessageDialog(null, "Dispositivo excluído com sucesso!");
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            } finally {
                em.close();
            }
        }
    }

    // ========================================================================
    // --- MÉTODOS PARA PEÇAS ---
    // ========================================================================

    /**
     * Retorna a lista de Peças direto do Banco de Dados.
     * @return 
     */
    public List<Pecas> listarPecas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Pecas> lista = null;
        try {
            TypedQuery<Pecas> query = em.createQuery("SELECT p FROM Pecas p", Pecas.class);
            lista = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar peças: " + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }

    /**
     * Salva ou Atualiza uma peça no banco.
     */
    public void salvarPeca(Pecas peca) {
        // Validação simples
        if (peca.getBrand() == null || peca.getBrand().isEmpty() || 
            peca.getModel() == null || peca.getModel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Marca e Modelo são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            
            if (peca.getID() == 0) {
                // INSERT
                em.persist(peca);
                JOptionPane.showMessageDialog(null, "Peça salva com sucesso!");
            } else {
                // UPDATE
                em.merge(peca);
                JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso!");
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao salvar peça: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
    }

    /**
     * Exclui uma peça do banco.
     */
    public void excluirPeca(Pecas peca) {
        if (peca == null) return;
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir a peça: " + peca.getModel() + "?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManager em = JPAUtil.getEntityManager();
            try {
                em.getTransaction().begin();
                Pecas p = em.find(Pecas.class, peca.getID());
                if (p != null) {
                    em.remove(p);
                    JOptionPane.showMessageDialog(null, "Peça excluída com sucesso!");
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            } finally {
                em.close();
            }
        }
    }
}