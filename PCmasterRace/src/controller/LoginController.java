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
    
        
    public User validarLogin( String login, String senha) {
        
        
        Cliente clienteCustom = (Cliente) Cliente.criarUsuarioTeste("cliente", "12345678");
        if(clienteCustom.getLogin().equals(login) && clienteCustom.getSenha().equals(senha)){
            return clienteCustom;
        }
        Tecnico tecnicoCustom = (Tecnico) Tecnico.criarUsuarioTeste("tecnico", "12345678");
        if(tecnicoCustom.getLogin().equals(login) && tecnicoCustom.getSenha().equals(senha)){
            return tecnicoCustom;
        }
        Gerente gerenteCustom = (Gerente) Gerente.criarUsuarioTeste("admin", "12345678");
        if(gerenteCustom.getLogin().equals(login) && gerenteCustom.getSenha().equals(senha)){
            return gerenteCustom;
        }
      
        
            
        return null;
    }

    
    
 
}
