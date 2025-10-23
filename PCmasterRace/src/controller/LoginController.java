/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.User;

/**
 *
 * @author gabri
 */
public class LoginController {
    
        
    public boolean validarLogin(User usuario, String login, String senha) {
        
        User usuarioCustom = User.criarUsuarioTeste("admin", "12345");
      
        if (usuario == null || login == null || senha == null ) {
            return false;
        }
            return usuario.getLogin().equals(login) && usuario.getSenha().equals(senha);
        
    }
    
 
}
