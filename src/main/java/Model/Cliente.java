/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author superbi
 */
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idUser")
public class Cliente extends User {

    public Cliente() {
        super();
        this.nivelAcesso = 3; // Define o atributo que o JPA vai ler
    }

    @Override
    public int getNivelAcesso() {
        return 3;
    }
    
    @Override
    public String toString() {
        return this.getNome(); // O ComboBox vai usar isso para exibir o texto
    }
    
    
}
