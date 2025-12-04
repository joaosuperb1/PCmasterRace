/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Cliente;
import Model.Tecnico;
import Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.NoResultException;
import java.util.List;

/**
 *
 * @author superbi
 */


public class UsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAO() {
        // O nome aqui deve ser IGUAL ao do persistence.xml
        emf = Persistence.createEntityManagerFactory("PCMasterRacePU");
    }

    public void salvar(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (user.getId() == 0) {
                em.persist(user); // Salva novo
            } else {
                em.merge(user);   // Atualiza existente
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public User autenticar(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            // JPQL: Busca objeto User baseado no login e senha
            return em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.senha = :senha", User.class)
                     .setParameter("login", login)
                     .setParameter("senha", senha)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null; // Usuário não encontrado ou senha errada
        } finally {
            em.close();
        }
    }
    
    public void fechar() {
        emf.close();
    }
    
    public List<User> listarPorTipo(Class type) {
    EntityManager em = emf.createEntityManager();
    try {
        // Busca polimórfica: Traz apenas o tipo específico
        String jpql = "SELECT u FROM " + type.getSimpleName() + " u";
        return em.createQuery(jpql, User.class).getResultList();
        } finally {
        em.close();
        }
    }
    
    public List<Cliente> listarClientes() {
    EntityManager em = emf.createEntityManager();
    try {
        // JPQL para buscar apenas os Clientes
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }
   
    
    public List<Tecnico> listarTecnicos() {
        EntityManager em = emf.createEntityManager();
        try {
            // JPQL para buscar apenas os Clientes
            return em.createQuery("SELECT t FROM Tecnico t", Tecnico.class).getResultList();
            } finally {
            em.close();
            }
    }
    
    

}

    
