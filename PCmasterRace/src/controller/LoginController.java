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
    
        
     public LoginResult validarLogin(String login, String senha) {
        User usuario = buscarUsuarioPorLogin(login);
        
        if (usuario == null) {
            return new LoginResult(false, null, "Usuário não encontrado");
        }
        
        if (!usuario.getSenha().equals(senha)) {
            return new LoginResult(false, null, "Senha incorreta");
        }
        
        return new LoginResult(true, usuario, "Login realizado com sucesso");
    }

     private User buscarUsuarioPorLogin(String login) {
        // Simulação de busca - na prática viria do banco de dados
        Map<String, User> usuarios = new HashMap<>();
        
        // Criando usuários de exemplo (usando seus métodos de criação)
        usuarios.put("cliente", Cliente.criarUsuarioTeste("cliente", "12345"));
        usuarios.put("funcionario", Funcionario.criarUsuarioTeste("funcionario", "12345"));
        usuarios.put("tecnico", Tecnico.criarUsuarioTeste("tecnico", "12345"));
        usuarios.put("gerente", Gerente.criarUsuarioTeste("gerente", "12345"));
        
        return usuarios.get(login);
    }
     
     // Método para obter informações detalhadas do usuário
    public void exibirInformacoesUsuario(User usuario) {
        System.out.println("Tipo: " + usuario.getClass().getSimpleName());
        System.out.println("Nível de acesso: " + usuario.getNivelAcesso());
        System.out.println("Login: " + usuario.getLogin());
    }
    
    // Getters
    public boolean isSucesso() { return sucesso; }
    public User getUsuario() { return usuario; }
    public String getMensagem() { return mensagem; }
    
    // Método útil para obter o nível de acesso
    public int getNivelAcessoUsuario() {
        return usuario != null ? usuario.getNivelAcesso() : 0;
    }
    
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
