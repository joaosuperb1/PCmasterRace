/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.exceptions.ValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author superbi
 */
public class ValidarLogin {

    private String login;
    private String senha;
    
    private static final String CAMINHO_CSV = "usuarios.csv";
    
     public ValidarLogin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    
    //Garante que os dados inseridos são válidos.
    public boolean ValidarLogin() throws ValidationException {
        // Validação do login
        if (login == null) {
            throw new ValidationException("Login não pode ser nulo.");
            
        }
        if (login.length() > 24) {
            throw new ValidationException("Login deve conter no máximo 24 caracteres.");
        }
        if (!login.matches("[a-zA-Z0-9]+")) {
            throw new ValidationException("Login deve conter apenas letras e números.");
        }

        // Validação da senha
        if (senha == null) {
            throw new ValidationException("Senha não pode ser nula.");
        }
        if (senha.length() > 32) {
            throw new ValidationException("Senha deve conter no máximo 32 caracteres.");
        }
        return true;
    }
    
    //Verifica se existe um usuário correspondente
    public int validateUser(String login, String senha){
        Cliente clienteCustom = (Cliente) Cliente.criarUsuarioTeste("cliente", "12345678");
        if(clienteCustom.getLogin().equals(login) && clienteCustom.getSenha().equals(senha)){
            return clienteCustom.getNivelAcesso();
        }
        Tecnico tecnicoCustom = (Tecnico) Tecnico.criarUsuarioTeste("tecnico", "12345678");
        if(tecnicoCustom.getLogin().equals(login) && tecnicoCustom.getSenha().equals(senha)){
            return tecnicoCustom.getNivelAcesso();
        }
        Gerente gerenteCustom = (Gerente) Gerente.criarUsuarioTeste("admin", "12345678");
        if(gerenteCustom.getLogin().equals(login) && gerenteCustom.getSenha().equals(senha)){
            return gerenteCustom.getNivelAcesso();
        }
        else{
            return 0;
        }
    }
    public int getUserID(String login, User custom){
        return custom.getID();
    }
}