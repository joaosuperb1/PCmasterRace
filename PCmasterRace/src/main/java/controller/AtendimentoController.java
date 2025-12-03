/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.Atendimento;
import Model.Cliente;
import Model.Tecnico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.TMcadAtendimento;

/**
 *
 * @author superbi

 */
    
public class AtendimentoController {

    public AtendimentoController() {
        // Construtor vazio
    }

    /**
     * Busca todos os atendimentos no Banco de Dados.
     * @return Lista de atendimentos do banco.
     */
    public List<Atendimento> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Atendimento> lista = null;
        
        try {
            // JPQL: Seleciona todos os objetos Atendimento
            // O JOIN FETCH pode ser necessário se você quiser carregar Cliente e Tecnico junto para evitar LazyInitializationException na tabela,
            // mas para começar, o SELECT simples funciona se as relações forem EAGER ou se a sessão estiver aberta (no caso aqui fechamos rápido, então cuidado).
            // Se der erro na tela ao exibir o nome do cliente, mude para: "SELECT a FROM Atendimento a JOIN FETCH a.cliente JOIN FETCH a.tecnico"
            TypedQuery<Atendimento> query = em.createQuery("SELECT a FROM Atendimento a", Atendimento.class);
            lista = query.getResultList();
            System.out.println("GERENCIADOR (BD): " + lista.size() + " atendimentos encontrados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar atendimentos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
        
        return lista;
    }

    /**
     * Salva (INSERT) ou Atualiza (UPDATE) um atendimento no banco.
     * @param atendimento Objeto preenchido na tela.
     */
    public void salvarAtendimento(Atendimento atendimento) {
        // Validação básica
        if (atendimento.getCliente() == null || atendimento.getTecnico() == null) {
            JOptionPane.showMessageDialog(null, "Cliente e Técnico são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();

            if (atendimento.getId() == 0) {
                // --- INSERT ---
                // O ID será gerado automaticamente pelo banco
                em.persist(atendimento);
                JOptionPane.showMessageDialog(null, "Atendimento salvo com sucesso!");
            } else {
                // --- UPDATE ---
                // O merge atualiza os dados do registro existente baseando-se no ID
                em.merge(atendimento);
                JOptionPane.showMessageDialog(null, "Atendimento atualizado com sucesso!");
            }

            em.getTransaction().commit();
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Exclui um atendimento do banco.
     * @param atendimento Objeto selecionado na tabela (deve ter ID).
     */
    public void excluirAtendimento(Atendimento atendimento) {
        if (atendimento == null) return;

        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir este atendimento?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManager em = JPAUtil.getEntityManager();
            try {
                em.getTransaction().begin();
                
                // Primeiro, buscamos o objeto "gerenciado" pelo ID para garantir que o Hibernate sabe quem remover
                Atendimento atendimentoParaRemover = em.find(Atendimento.class, atendimento.getId());
                
                if (atendimentoParaRemover != null) {
                    em.remove(atendimentoParaRemover);
                    JOptionPane.showMessageDialog(null, "Atendimento excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Atendimento não encontrado no banco (talvez já excluído).");
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
    
    public List<Atendimento> listarPorCliente(int idCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Atendimento> lista = null;
        try {
            // JPQL: Filtra onde o objeto 'cliente' dentro de 'Atendimento' tem o ID igual ao parâmetro
            TypedQuery<Atendimento> query = em.createQuery(
                "SELECT a FROM Atendimento a WHERE a.cliente.id = :id", 
                Atendimento.class
            );
            query.setParameter("id", idCliente);
            lista = query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar atendimentos do cliente: " + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }
}