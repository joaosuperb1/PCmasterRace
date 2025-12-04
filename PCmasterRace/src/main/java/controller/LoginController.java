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

    private final ValidarLogin validator;
    private final UsuarioDAO usuarioDAO;

    public LoginController() {
        this.validator = new ValidarLogin();
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean valueValidator(String login, String senha){
        
        try {
            validator.validateLogin(login, senha);
            return true;
            
        } catch (ValidationException e) {
            System.out.println("Erro de validação: " + e.getMessage());
            return false;
        }
        
    }
    
    /**
     * Tenta realizar o login.
     * * @param login O login digitado
     * @param senha A senha digitada
     * @return O objeto Usuario se der certo, ou null se login/senha estiverem errados no banco.
     * @throws ValidationException Se o formato do texto estiver errado (ex: senha vazia).
     */
    public User autenticar(String login, String senha) throws ValidationException {
        
        // 1. Validação de Regras de Negócio (Formato)
        // Se houver erro (ex: campo vazio), o ValidarLogin vai lançar a exceção
        // e nós deixamos ela "subir" para a tela tratar.
        

        // 2. Busca no Banco de Dados
        // Se chegou aqui, o texto é válido. Agora conferimos se existe no banco.
        User usuarioEncontrado = usuarioDAO.autenticar(login, senha);
        
        return usuarioEncontrado;
    }
}