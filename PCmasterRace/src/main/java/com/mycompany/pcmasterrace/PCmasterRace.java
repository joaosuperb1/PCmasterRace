/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pcmasterrace;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import view.FrLogin;
import view.FrHome;

/**
 *
 * @author superbi
 */
public class PCmasterRace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PCMasterRacePU");
        EntityManager entityManager = factory.createEntityManager();

        
        FrHome home = new FrHome();
        home.setVisible(true);
        
        
        entityManager.close();
        factory.close();
        
        
    }

}
