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
public class Tecnico extends User{
    
    public Tecnico() {
        super();
        this.nivelAcesso = 2; // Define o atributo que o JPA vai ler
    }

    @Override
    public int getNivelAcesso() {
        return 2;
    }
}
