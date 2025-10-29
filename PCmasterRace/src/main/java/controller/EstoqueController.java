/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

// Importações assumidas com base nos nomes das classes
import Model.Dispositivos;
import Model.Pecas;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author superbi
 */
public class EstoqueController {

    // --- Nossos Bancos de Dados Falsos "Hard-Coded" ---
    // Uma lista para Dispositivos e outra para Peças
    private static final List<Dispositivos> bancoDispositivosFalso = new ArrayList<>();
    private static final List<Pecas> bancoPecasFalso = new ArrayList<>();
    
    private static int proximoIdDispositivo = 1;
    private static int proximoIdPeca = 1;

    // --- Bloco de inicialização estático (com os dados falsos) ---
    static {
        // 1. Crie Dispositivos falsos (assumindo que têm setters)
        Dispositivos d1 = new Dispositivos();
        d1.setID(proximoIdDispositivo++); // ID: 1
        d1.setBrand("Samsung");
        d1.setModel("Galaxy S21");
        d1.setCondicao("Usado - Bom");
        d1.setCusto(1200.00);
        d1.setPreco(1800.00);

        Dispositivos d2 = new Dispositivos();
        d2.setID(proximoIdDispositivo++); // ID: 2
        d2.setBrand("Dell");
        d2.setModel("Latitude 5490");
        d2.setCondicao("Recondicionado");
        d2.setCusto(1500.00);
        d2.setPreco(2500.00);

        bancoDispositivosFalso.add(d1);
        bancoDispositivosFalso.add(d2);

        // 2. Crie Peças falsas (assumindo que têm setters)
        Pecas p1 = new Pecas();
        p1.setID(proximoIdPeca++); // ID: 1
        p1.setBrand("Kingston");
        p1.setModel("A400 SSD 240GB");
        p1.setCondicao("Novo");
        p1.setCusto(100.00);
        p1.setPreco(180.00);

        Pecas p2 = new Pecas();
        p2.setID(proximoIdPeca++); // ID: 2
        p2.setBrand("Samsung");
        p2.setModel("Tela AMOLED S21");
        p2.setCondicao("Novo");
        p2.setCusto(450.00);
        p2.setPreco(750.00);

        bancoPecasFalso.add(p1);
        bancoPecasFalso.add(p2);
        
        System.out.println("HARD-CODED: Bloco estático do EstoqueController executado, " 
            + bancoDispositivosFalso.size() + " dispositivos e " 
            + bancoPecasFalso.size() + " peças carregados.");
    }
    // --- Fim do Bloco Estático ---

    /**
     * Construtor (vazio).
     */
    public EstoqueController() {
        // Construtor vazio
    }
    
    
    
    // --- MÉTODOS PARA DISPOSITIVOS ---

    /**
     * Retorna a lista de Dispositivos.
     * @return Uma cópia da lista de dispositivos.
     */
    public List<Dispositivos> listarDispositivos() {
        System.out.println("GERENCIADOR: Listando dispositivos... " + bancoDispositivosFalso.size() + " encontrados.");
        return new ArrayList<>(bancoDispositivosFalso); // Retorna uma cópia
    }

    /**
     * Salva ou Atualiza um dispositivo na lista.
     */
    public void salvarDispositivo(Dispositivos dispositivo) {
        try {
            // Validação simples
            if (dispositivo.getBrand() == null || dispositivo.getBrand().isEmpty() || dispositivo.getModel() == null || dispositivo.getModel().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Marca e Modelo são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (dispositivo.getID() == 0) {
                dispositivo.setID(proximoIdDispositivo++); 
                bancoDispositivosFalso.add(dispositivo);
                JOptionPane.showMessageDialog(null, "Dispositivo salvo com sucesso!");
            } else {
                for (int i = 0; i < bancoDispositivosFalso.size(); i++) {
                    if (bancoDispositivosFalso.get(i).getID() == dispositivo.getID()) {
                        bancoDispositivosFalso.set(i, dispositivo);
                        JOptionPane.showMessageDialog(null, "Dispositivo atualizado com sucesso!");
                        return; // Sai do método
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dispositivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Exclui um dispositivo da lista.
     * @param dispositivo
     */
    public void excluirDispositivo(Dispositivos dispositivo) {
        if (dispositivo == null) { return; }
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir o dispositivo: " + dispositivo.getModel() + "?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            bancoDispositivosFalso.removeIf(d -> d.getID() == dispositivo.getID());
            JOptionPane.showMessageDialog(null, "Dispositivo excluído com sucesso!");
        }
    }

    // --- MÉTODOS PARA PEÇAS ---

    /**
     * Retorna a lista de Peças.
     * @return Uma cópia da lista de peças.
     */
    public List<Pecas> listarPecas() {
        System.out.println("GERENCIADOR: Listando peças... " + bancoPecasFalso.size() + " encontradas.");
        return new ArrayList<>(bancoPecasFalso); // Retorna uma cópia
    }

    /**
     * Salva ou Atualiza uma peça na lista.
     * @param peca
     */
    public void salvarPeca(Pecas peca) {
        try {
            // Validação simples
            if (peca.getBrand() == null || peca.getBrand().isEmpty() || peca.getModel() == null || peca.getModel().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Marca e Modelo são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (peca.getID() == 0) { // Assumindo que Peças também usa getId/setId
                peca.setID(proximoIdPeca++); 
                bancoPecasFalso.add(peca);
                JOptionPane.showMessageDialog(null, "Peça salva com sucesso!");
            } else {
                for (int i = 0; i < bancoPecasFalso.size(); i++) {
                    if (bancoPecasFalso.get(i).getID() == peca.getID()) {
                        bancoPecasFalso.set(i, peca);
                        JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso!");
                        return; // Sai do método
                    }
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar peça: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Exclui uma peça da lista.
     * @param peca
     */
    public void excluirPeca(Pecas peca) {
        if (peca == null) { return; }
        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja excluir a peça: " + peca.getModel() + "?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            bancoPecasFalso.removeIf(p -> p.getID() == peca.getID()); // Assumindo que Peças usa getId
            JOptionPane.showMessageDialog(null, "Peça excluída com sucesso!");
        }
    }
}