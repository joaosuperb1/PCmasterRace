/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Atendimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author superbi
 */
public class TMcadAtendimento extends AbstractTableModel {

    /**
     * Lista de atendimentos que serão exibidos na tabela.
     */
    private List<Atendimento> listaDeAtendimentos;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     */
    private final String[] colunas = {"ID", "Data", "Cliente", "Técnico", "Status", "Preço", "Descrição"};

    /**
     * Construtor padrão. Inicializa com uma lista vazia.
     */
    public TMcadAtendimento() {
        this.listaDeAtendimentos = new ArrayList<>();
    }

    /**
     * Construtor que já recebe a lista de atendimentos.
     * @param listaDeAtendimentos Lista de atendimentos a ser exibida.
     */
    public TMcadAtendimento(List<Atendimento> listaDeAtendimentos) {
        this.listaDeAtendimentos = listaDeAtendimentos;
    }

    // --- Métodos Essenciais do AbstractTableModel ---

    /**
     * Retorna o número de linhas na tabela (tamanho da lista).
     */
    @Override
    public int getRowCount() {
        return listaDeAtendimentos.size();
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
        // Pega o atendimento para a linha específica
        Atendimento atendimento = listaDeAtendimentos.get(rowIndex);

        // Retorna o atributo do atendimento com base no índice da coluna
        // **IMPORTANTE:** Requer getters públicos na classe Atendimento!
        // E requer getNome() nas classes Cliente e Tecnico.
        switch (columnIndex) {
            case 0: // Coluna "ID"
                return atendimento.getId();
            case 1: // Coluna "Data"
                return atendimento.getData_atendimento();
            case 2: // Coluna "Cliente"
                // Retorna o nome do cliente, ou "N/D" se o cliente for nulo
                return (atendimento.getCliente() != null) ? atendimento.getCliente().getNome() : "N/D";
            case 3: // Coluna "Técnico"
                // Retorna o nome do técnico, ou "N/D" se o técnico for nulo
                return (atendimento.getTecnico() != null) ? atendimento.getTecnico().getNome() : "N/D";
            case 4: // Coluna "Status"
                return atendimento.getStatus();
            case 5: // Coluna "Preço"
                return atendimento.getPreco();
            case 6: // Coluna "Descrição"
                return atendimento.getDescricao();
            default:
                // Retorna null se o índice da coluna for inválido
                return null;
        }
    }

    // --- Métodos Auxiliares para Manipular a Lista ---

    /**
     * Adiciona um atendimento ao final da lista e notifica a JTable.
     * @param atendimento O atendimento a ser adicionado.
     */
    public void addAtendimento(Atendimento atendimento) {
        this.listaDeAtendimentos.add(atendimento);
        // Notifica a tabela que uma nova linha foi inserida na última posição
        int lastRow = getRowCount() - 1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    /**
     * Remove um atendimento da lista com base no índice (linha) e notifica a JTable.
     * @param rowIndex O índice da linha a ser removida.
     */
    public void removeAtendimento(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeAtendimentos.size()) {
            this.listaDeAtendimentos.remove(rowIndex);
            // Notifica a tabela que a linha foi removida
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    /**
     * Retorna o objeto Atendimento da linha especificada.
     * Útil para obter o objeto selecionado na tabela.
     * @param rowIndex O índice da linha.
     * @return O objeto Atendimento.
     */
    public Atendimento getAtendimento(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeAtendimentos.size()) {
            return listaDeAtendimentos.get(rowIndex);
        }
        return null;
    }

    /**
     * Atualiza toda a lista de atendimentos e notifica a JTable para redesenhar.
     * @param novaLista A nova lista de atendimentos.
     */
    public void setListaDeAtendimentos(List<Atendimento> novaLista) {
        this.listaDeAtendimentos = novaLista;
        // Notifica a tabela que todos os dados mudaram
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
                return Integer.class;
            case 1: // Data
            case 2: // Cliente
            case 3: // Técnico
            case 4: // Status
            case 5: // Preço (definido como String na sua classe)
            case 6: // Descrição
                return String.class;
            default:
                return Object.class;
        }
    }
}