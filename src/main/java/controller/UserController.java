/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

// Importações assumidas com base nas suas classes de Usuário
import Model.User;
import Model.Cliente;
import Model.Tecnico;
import Model.Gerente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author superbi
 */
public class UserController {

    // --- Nosso Banco de Dados Falso "Hard-Coded" ---
    // Uma lista única para todos os tipos de Usuários (Gerente, Tecnico, Cliente)
    private static final List<User> bancoUsuariosFalso = new ArrayList<>();
    
    private static int proximoIdUsuario = 1;

    // --- Bloco de inicialização estático (com os dados falsos) ---
    static {
        // 1. Crie Usuários falsos (assumindo que User tem setters para seus campos)
        
        // Gerente (Nível 1)
        Gerente g1 = new Gerente();
        g1.setId(proximoIdUsuario++); // ID: 1
        g1.setNome("Ana Gerente");
        g1.setIdade(45);
        g1.setCpf("111.111.111-11");
        g1.setLogin("gerente.ana");
        g1.setSenha("senha123"); // Em um app real, isso seria criptografado

        // Tecnico (Nível 2)
        Tecnico t1 = new Tecnico();
        t1.setId(proximoIdUsuario++); // ID: 2
        t1.setNome("Bruno Tecnico");
        t1.setIdade(30);
        t1.setCpf("222.222.222-22");
        t1.setLogin("tecnico.bruno");
        t1.setSenha("senha456");

        // Cliente (Nível 3)
        Cliente c1 = new Cliente();
        c1.setId(proximoIdUsuario++); // ID: 3
        c1.setNome("Carla Cliente");
        c1.setIdade(22);
        c1.setCpf("333.333.333-33");
        c1.setLogin("cliente.carla");
        c1.setSenha("senha789");

        bancoUsuariosFalso.add(g1);
        bancoUsuariosFalso.add(t1);
        bancoUsuariosFalso.add(c1);
        
        System.out.println("HARD-CODED: Bloco estático do UserController executado, " 
                + bancoUsuariosFalso.size() + " usuários carregados.");
    }
    // --- Fim do Bloco Estático ---

    /**
     * Construtor (vazio).
     */
    public UserController() {
        // Construtor vazio
    }

    /**
     * Tenta autenticar um usuário com base no login e senha.
     * @param login O login do usuário.
     * @param senha A senha (texto plano).
     * @return O objeto User se a autenticação for bem-sucedida, ou null se falhar.
     */
    public User autenticar(String login, String senha) {
        for (User user : bancoUsuariosFalso) {
            // Assumindo que a classe User tem getters getLogin() e getSenha()
            if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                System.out.println("AUTENTICAÇÃO: Sucesso para " + login + ". Nível: " + user.getNivelAcesso());
                return user; // Encontrou
            }
        }

        // Se o loop terminar, o usuário não foi encontrado ou a senha estava errada
        System.out.println("AUTENTICAÇÃO: Falha para " + login);
        JOptionPane.showMessageDialog(null, "Login ou senha incorretos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    /**
     * Retorna a lista completa de Usuários (de todos os tipos).
     * @return Uma cópia da lista de usuários.
     */
    public List<User> listarUsuarios() {
        System.out.println("GERENCIADOR: Listando usuários... " + bancoUsuariosFalso.size() + " encontrados.");
        return new ArrayList<>(bancoUsuariosFalso); // Retorna uma cópia
    }

    /**
     * Salva ou Atualiza um usuário na lista.
     * @param usuario O usuário (Cliente, Tecnico ou Gerente) a ser salvo.
     */
    public void salvarUsuario(User usuario) {
        try {
            // Validação simples (assumindo getters)
            if (usuario.getNome() == null || usuario.getNome().isEmpty() || usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome e Login são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (usuario.getId() == 0) {
                // --- CRIAR NOVO USUÁRIO ---
                usuario.setId(proximoIdUsuario++); 
                bancoUsuariosFalso.add(usuario);
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            } else {
                // --- ATUALIZAR USUÁRIO EXISTENTE ---
                for (int i = 0; i < bancoUsuariosFalso.size(); i++) {
                    if (bancoUsuariosFalso.get(i).getId() == usuario.getId()) {
                        bancoUsuariosFalso.set(i, usuario); // Substitui o antigo pelo novo
                        JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                        return; // Sai do método
                    }
                }
                // Se saiu do loop sem encontrar, é um ID inválido (embora raro neste fluxo)
                JOptionPane.showMessageDialog(null, "Usuário não encontrado para atualização.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Exclui um usuário da lista.
     * @param usuario O usuário a ser excluído.
     */
    public void excluirUsuario(User usuario) {
        if (usuario == null) { return; }
        
        // Não permitir excluir o primeiro gerente (ID 1) como regra de segurança
        if (usuario.getId() == 1) {
             JOptionPane.showMessageDialog(null, "Não é possível excluir o administrador principal.", "Ação Bloqueada", JOptionPane.WARNING_MESSAGE);
             return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir o usuário: " + usuario.getNome() + "?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Remove o usuário da lista com base no ID
            bancoUsuariosFalso.removeIf(u -> u.getId() == usuario.getId());
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        }
    }
}