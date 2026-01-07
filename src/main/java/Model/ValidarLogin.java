/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.exceptions.ValidationException;
import controller.UsuarioDAO;
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
    
    // Removido: CAMINHO_CSV (não é mais necessário com JPA)

    public ValidarLogin() {
        this.login = null;
        this.senha = null;
    }
    

    public ValidarLogin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    /**
     * Passo 1: Garante que os dados inseridos (texto) são válidos antes de ir ao banco.
     */
    public boolean validateLogin(String login, String senha) throws ValidationException {
        // Validação do login
        if (login == null || login.trim().isEmpty()) {
            throw new ValidationException("Login não pode ser nulo ou vazio.");
        }
        if (login.length() > 24) {
            throw new ValidationException("Login deve conter no máximo 24 caracteres.");
        }
        // Exemplo: Permitir apenas letras e números
        if (!login.matches("[a-zA-Z0-9]+")) {
            throw new ValidationException("Login deve conter apenas letras e números.");
        }

        // Validação da senha
        if (senha == null || senha.trim().isEmpty()) {
            throw new ValidationException("Senha não pode ser nula.");
        }
        if (senha.length() > 32) {
            throw new ValidationException("Senha deve conter no máximo 32 caracteres.");
        }
        
        // Atualiza os atributos da classe se passar na validação
        this.login = login;
        this.senha = senha;
        
        return true;
    }
    
    /**
     * Passo 2: Verifica no Banco de Dados se o usuário existe.
     * Retorna o nível de acesso (int) ou 0 se falhar.
     */
    public int validateUser(String login, String senha) {
        
        // 1. Instancia o DAO
        UsuarioDAO dao = new UsuarioDAO();
        
        // 2. Tenta buscar o usuário no banco
        // Assumindo que sua classe 'Usuario' (pai de Cliente/Tecnico) tem o metodo getNivelAcesso()
        User usuarioEncontrado = dao.autenticar(login, senha);
        
        if (usuarioEncontrado != null) {
            // Se achou, retorna o nível de acesso real do banco
            return usuarioEncontrado.getNivelAcesso(); 
        } else {
            // Se retornou null, login ou senha estão incorretos
            return 0;
        }
    }
    
    // Método auxiliar para pegar o ID (agora buscando do banco também se necessário)
    public int getUserID(String login) {
         UsuarioDAO dao = new UsuarioDAO();
         // Nota: Voce precisaria de um metodo buscarPorLogin(login) no DAO se não tiver a senha aqui
         // Mas seguindo a lógica atual:
         return 0; // Implementar conforme necessidade
    }
}