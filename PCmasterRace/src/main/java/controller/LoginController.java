/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.User;
import Model.ValidarLogin;
import Model.exceptions.ValidationException;

/**
 *
 * @author gabri
 */



public class LoginController {
    private ValidarLogin validator = new ValidarLogin();
    private String login;
    private String senha;
    
    public LoginController(){
        this.login = null;
        this.senha = null;
    }
    
    public LoginController(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public boolean valueValidator(String login, String senha){
        
        try {
            validator.ValidarLogin();
            return true;
            
        } catch (ValidationException e) {
            System.out.println("Erro de validação: " + e.getMessage());
            return false;
        }
        
    }
    
    public User validarLogin( String login, String senha) {
        if(this.valueValidator(login, senha)){
         return null;   
        } else {
            return null;
        }
    }
    
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    
    
    

    
    
 
}
