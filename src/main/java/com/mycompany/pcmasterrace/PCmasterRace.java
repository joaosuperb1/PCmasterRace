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
        // Apenas inicie a tela visual
        // O banco será chamado sob demanda pelos botões da tela
        try {
            FrHome home = new FrHome();
            home.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
