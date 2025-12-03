/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Model.Cliente;
import Model.Gerente;
import Model.Tecnico;
import controller.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author superbi
 */
public class PopularBD {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();

            // 1. Criar Gerente (Admin)
            Gerente gerente = new Gerente();
            gerente.setNome("Super Admin");
            gerente.setLogin("admin");
            gerente.setSenha("admin123");
            gerente.setNivelAcesso();
            em.persist(gerente);

            // 2. Criar Técnicos
            Tecnico tec1 = new Tecnico();
            tec1.setNome("Roberto Silva");
            tec1.setLogin("roberto");
            tec1.setSenha("123");
            tec1.setNivelAcesso();
            em.persist(tec1);

            // 3. Criar Clientes em Massa (Loop)
            for (int i = 1; i <= 10; i++) {
                Cliente cliente = new Cliente();
                cliente.setNome("Cliente Teste " + i);
                cliente.setLogin("cliente" + i);
                cliente.setSenha("123");
                cliente.setCpf("000.000.000-0" + i);
                cliente.setNivelAcesso();
                
                em.persist(cliente);
            }

            em.getTransaction().commit();
            System.out.println("Banco povoado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close(); // Fecha a fábrica
        }
    }
}
