/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Cliente;
import Model.Funcionario;
import Model.Gerente;
import Model.Tecnico;
import Model.User;

/**
 *
 * @author gabri
 */
public class LoginController {
    
        
    public boolean validarLogin(User usuario, String login, String senha) {
        
        Cliente usuarioCustom1 = (Cliente) Cliente.criarUsuarioTeste("admin", "12345");
        Funcionario usuarioCustom2 = (Funcionario) Funcionario.criarUsuarioTeste("admin", "12345");
        Tecnico usuarioCustom3 = (Tecnico) Tecnico.criarUsuarioTeste("admin", "12345");
        Gerente usuarioCustom4 = (Gerente) Gerente.criarUsuarioTeste("admin", "12345");
      
        if (usuario == null || login == null || senha == null ) {
            return false;
        }
            return usuario.getLogin().equals(login) && usuario.getSenha().equals(senha);
        
    }
    
 
}
