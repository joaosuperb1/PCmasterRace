/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author superbi
 */
public class ValidarLogin {

    
    private static final String CAMINHO_CSV = "usuarios.csv";

    public boolean validar(String usuario, String senha) {
        // Verifica se os campos não são nulos para evitar NullPointerException
        if (usuario == null || senha == null) {
            return false;
        }

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