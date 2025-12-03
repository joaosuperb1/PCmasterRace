/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.List;
import java.util.Objects;
import jakarta.persistence.*;

/**
 *
 * @author superbi
 */


@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Cria uma tabela para User e tabelas separadas para os filhos
public abstract class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nome;
    protected int idade;
    private String cpf;
    private String login;
    private String senha;
    protected int nivelAcesso;

    
    public User() {
        this.id = 0;
        this.nome = "";
        this.idade = 0;
        this.cpf = "000.000.000-00"; 
        this.login = "";
        this.senha = "";
        this.nivelAcesso = 0;
    }
    
    public User(int id, String nome, int idade, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    } 
    
    // Métodos abstratos que devem ser implementados pelas subclasses
    public abstract int getNivelAcesso();

    
    //Criar usuario Teste
    public static User criarUsuarioTeste(String login, String senha) {
        return new User(1, "Usuário Teste", 25, "111.111.111-11", login, senha) {
            @Override
            public int getNivelAcesso() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        };
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
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + this.idade;
        hash = 71 * hash + Objects.hashCode(this.cpf);
        hash = 71 * hash + Objects.hashCode(this.login);
        hash = 71 * hash + Objects.hashCode(this.senha);
        return hash;
    }
    
    public int getUser(String login, User custom){
        if(login.equals(custom.getLogin())){
            return custom.getId();
        }
        return -1;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha + '}';
    }
    

    
}



