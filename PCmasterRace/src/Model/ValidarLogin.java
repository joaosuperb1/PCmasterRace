/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author superbi
 */
public class ValidarLogin {
   
    private static final String USUARIO_CORRETO = "admin";
    private static final String SENHA_CORRETA = "123";

    public boolean validar(String usuario, String senha) {
        // Verifica se os campos não são nulos para evitar NullPointerException
        if (usuario == null || senha == null) {
            return false;
        }

        // Compara o usuário e a senha fornecidos com os valores corretos.
        // É crucial usar o método .equals() para comparar o conteúdo de Strings em Java.
        return usuario.equals(USUARIO_CORRETO) && senha.equals(SENHA_CORRETA);
    }
}
