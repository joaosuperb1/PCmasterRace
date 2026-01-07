/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

// Importações necessárias (assumindo que estão no pacote Model)
import Model.User;
import Model.Cliente;
import Model.Gerente;
import Model.Tecnico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel para gerenciar a exibição de *apenas Funcionários* (Gerente, Tecnico).
 *
 * @author superbi
 */
public class TMcadUser extends AbstractTableModel {

    /**
     * Lista genérica para guardar Usuários (filtrada para conter apenas funcionários).
     */
    private List<Object> listaDeUsuarios;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     */
    private final String[] colunas = {"ID", "Nome", "Login", "CPF", "Idade", "Cargo"}; // Mudei "Tipo" para "Cargo"

    /**
     * Construtor padrão. Inicializa com uma lista vazia.
     */
    public TMcadUser() {
        this.listaDeUsuarios = new ArrayList<>();
    }

    /**
     * Construtor que já recebe a lista de usuários e a FILTRA.
     * @param listaDeItens Lista de usuários a ser filtrada.
     */
    public TMcadUser(List<?> listaDeItens) {
        // Usa o método auxiliar para filtrar e configurar a lista interna
        filtrarEConfigurarLista(listaDeItens);
    }
    
    /**
     * Método auxiliar privado para filtrar a lista e manter apenas funcionários.
     * @param listaCompleta A lista original com todos os tipos de usuários.
     */
    private void filtrarEConfigurarLista(List<?> listaCompleta) {
        // Inicializa ou limpa a lista interna
        this.listaDeUsuarios = new ArrayList<>(); 
        
        if (listaCompleta == null) {
            return;
        }
        
        // Itera sobre a lista completa
        for (Object item : listaCompleta) {
            // Verifica se é um usuário
            if (item instanceof User) {
                User u = (User) item;
                
                // **** FILTRO PRINCIPAL ****
                // Adiciona apenas se o Nível de Acesso for < 3 (ou seja, 1 ou 2)
                if (u.getNivelAcesso() < 3) { 
                    this.listaDeUsuarios.add(u);
                }
            }
        }
    }
    
    
    // --- Métodos Essenciais do AbstractTableModel ---

    /**
     * Retorna o número de linhas na tabela (tamanho da lista JÁ FILTRADA).
     */
    @Override
    public int getRowCount() {
        return listaDeUsuarios.size();
    }

    /**
     * Retorna o número de colunas da tabela.
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o nome da coluna para o índice especificado.
     */
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    /**
     * Retorna o valor a ser exibido na célula especificada (linha, coluna).
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o item (que já sabemos ser um funcionário)
        Object item = listaDeUsuarios.get(rowIndex);
        User u = (User) item;

        switch (columnIndex) {
            case 0: return u.getId();
            case 1: return u.getNome();
            case 2: return u.getLogin();
            case 3: return u.getCpf(); 
            case 4: return u.getIdade();
            case 5: 
                // Diferencia o cargo do funcionário
                if (u instanceof Gerente) return "Gerente";
                if (u instanceof Tecnico) return "Técnico";
                return "Funcionário"; // Fallback
            default: 
                return null;
        }
    }

    // --- Métodos Auxiliares para Manipular a Lista ---

    /**
     * Adiciona um item (User) ao final da lista, SE for um funcionário.
     * @param item O item a ser adicionado.
     */
    public void addItem(Object item) {
        if (item instanceof User) {
            User u = (User) item;
            // Apenas adiciona se for funcionário (Nível 1 ou 2)
            if (u.getNivelAcesso() < 3) { 
                this.listaDeUsuarios.add(item);
                int lastRow = getRowCount() - 1;
                fireTableRowsInserted(lastRow, lastRow);
            }
        }
    }

    /**
     * Remove um item da lista com base no índice (linha) e notifica a JTable.
     */
    public void removeItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeUsuarios.size()) {
            this.listaDeUsuarios.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    /**
     * Retorna o objeto (User) da linha especificada.
     */
    public Object getItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeUsuarios.size()) {
            return listaDeUsuarios.get(rowIndex);
        }
        return null;
    }

    /**
     * Atualiza toda a lista de itens, FILTRANDO-A, e notifica a JTable.
     * @param novaLista A nova lista completa (com Clientes, Técnicos, etc.).
     */
    public void setLista(List<?> novaLista) {
        // Usa o método auxiliar para filtrar a nova lista
        filtrarEConfigurarLista(novaLista);
        
        // Notifica a tabela que os dados mudaram completamente
        fireTableDataChanged();
    }

    /**
     * Controla se as células da tabela são editáveis (por padrão, não são).
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Ajuda a JTable a usar o renderizador correto para cada tipo de dado.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // ID
            case 4: // Idade
                return Integer.class;
            case 1: // Nome
            case 2: // Login
            case 3: // CPF
            case 5: // Cargo
                return String.class;
            default:
                return Object.class;
        }
    }
}