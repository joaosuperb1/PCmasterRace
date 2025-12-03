/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author superbi
 */


public class JPAUtil {

    // A fábrica é criada apenas UMA vez (static)
    // O texto abaixo DEVE ser igual ao que está no seu persistence.xml
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PCMasterRacePU"); 

    /**
     * Entrega uma conexão pronta para uso (EntityManager)
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
    
    /**
     * Fecha a fábrica ao encerrar a aplicação (opcional, mas recomendado)
     */
    public static void close() {
        if (FACTORY.isOpen()) {
            FACTORY.close();
        }
    }
}