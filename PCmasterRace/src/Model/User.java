/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author superbi
 */
public class User {
    protected String nome;
    protected char sexo;
    protected int idade;
    
    public User() {
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
    }
    
    public User(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    } 

    public String toString() {
        String txt = "Nome: " + this.nome +"\n"
        +"Sexo: "+ this.sexo + "\n"
        +"Idade: "+ this.idade+"\n";
        return txt;
    }   
    
    @Override
    public boolean equals(Object obj) {
        User outro = (User) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.idade != outro.getIdade())
            return false;
        else if(this.sexo != outro.getSexo())
            return false;
        
        return true;
    }
    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public char getSexo() {
        return sexo;
    }

    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    public int getIdade() {
        return idade;
    }

    
    public void setIdade(int idade) {
        this.idade = idade;
    }

}



