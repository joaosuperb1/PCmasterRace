/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author superbi
 */

//@Entity
public class User {
    
    /*
    
    Acabei de ver na aula do seu zé 
    
    @Id // chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar ID
    */
    protected int id;
    protected String nome;
    protected int idade;
    private String cpf;
    
    public User() {
        this.id = 0;
        this.nome = "";
        this.idade = 0;
        this.cpf = "000.000.000-00";   
    }
    
    public User(int id, String nome, int idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    } 

    public String toString() {
        String txt = "ID: "+ this.id + "Nome: " + this.nome +"\n"
        + "\n" +"Idade: "+ this.idade+"\n" + "CPF: " + this.cpf + "\n";
        return txt;
    }   
    
    @Override
    public boolean equals(Object obj) {
        User outro = (User) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.idade != outro.getIdade())
            return false;
        return true;
    }
    
    
        public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }

}



