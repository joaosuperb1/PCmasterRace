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
    
    //Garante que os dados inseridos são válidos.
    public void ValueValidator() throws ValidationException {
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
    }
    
    //Verifica se existe um usuário correspondente
    
    public boolean validar(String usuario, String senha) {
        
       

        // A estrutura 'try-with-resources' garante que o BufferedReader será fechado automaticamente.
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_CSV))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");

                if (valores.length >= 2) {
                    String loginDoCsv = valores[0];
                    String senhaDoCsv = valores[1];

                    if (loginDoCsv.equals(usuario) && senhaDoCsv.equals(senha)) {
                        return true; 
                    }
                }
            }
        } catch (IOException e) {
            
            // imprime o erro e falha a validação.
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
            return false;
        }

        // Se o loop terminar e nenhuma correspondência for encontrada, o login é inválido.
        return false;
    }
}