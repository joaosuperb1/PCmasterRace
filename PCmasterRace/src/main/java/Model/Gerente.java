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
public class Gerente extends User {
    
    public Gerente() {
        super();
        this.nivelAcesso = 1; // Define o atributo que o JPA vai ler
    }

    @Override
    public int getNivelAcesso() {
        return 1;
    }
    
    

    
}
