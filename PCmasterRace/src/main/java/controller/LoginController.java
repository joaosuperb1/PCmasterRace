/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.ValidarLogin;
import Model.exceptions.ValidationException;

/**
 *
 * @author gabri
 */
public class LoginController {
    
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
    
    public boolean valueValidator(){
        ValidarLogin validator = new ValidarLogin(this.login, this.senha);
        try {
            validator.ValidarLogin();
            
            
        } catch (ValidationException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }
        return true;
    }
    
    public int validaLogin( String login, String senha) {
        ValidarLogin validate = new ValidarLogin(login, senha);
        return validate.validateUser(login, senha);
    }
    
    

    
    
 
}
