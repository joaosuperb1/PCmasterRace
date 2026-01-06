/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author superbi
 */
public class TMcadTecnico extends AbstractTableModel {

    /**
     * Lista de tecnicos que serão exibidos na tabela.
     */
    private List<Tecnico> listaDeTecnicos;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     */
    private final String[] colunas = {"ID", "Nome", "Idade", "CPF", "Login"};

    /**
     * Construtor padrão. Inicializa com uma lista vazia.
     */
    public TMcadTecnico() {
        this.listaDeTecnicos = new ArrayList<>();
    }

    /**
     * Construtor que já recebe a lista de tecnicos.
     * @param listaDeTecnicos Lista de tecnicos a ser exibida.
     */
    public TMcadTecnico(List<Tecnico> listaDeTecnicos) {
        this.listaDeTecnicos = listaDeTecnicos;
    }

    // --- Métodos Essenciais do AbstractTableModel ---

    /**
     * Retorna o número de linhas na tabela (que é o tamanho da lista de tecnicos).
     */
    @Override
    public int getRowCount() {
        return listaDeTecnicos.size();
    }

    /**
     * Retorna o número de colunas da tabela (definido pelo array 'colunas').
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o nome da coluna para o índice especificado.
     * @param columnIndex O índice da coluna.
     * @return O nome da coluna.
     */
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    /**
     * Retorna o valor a ser exibido na célula especificada (linha, coluna).
     * @param rowIndex O índice da linha.
     * @param columnIndex O índice da coluna.
     * @return O objeto (dado) a ser exibido.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o tecnico para a linha específica
        Tecnico tecnico = listaDeTecnicos.get(rowIndex);

        switch (columnIndex) {
            case 0: // Coluna "ID"
                return tecnico.getId();
            case 1: // Coluna "Nome"
                return tecnico.getNome();
            case 2: // Coluna "Idade"
                return tecnico.getIdade();
            case 3: // Coluna "CPF"
                return tecnico.getCpf();
            case 4: // Coluna "Login"
                return tecnico.getLogin();
            default:
                return null;
        }
    }

    // --- Métodos Auxiliares para Manipular a Lista ---

    public void addTecnico(Tecnico tecnico) {
        this.listaDeTecnicos.add(tecnico);
        int lastRow = getRowCount() - 1;
        // Agora este método existe porque herdamos de AbstractTableModel
        fireTableRowsInserted(lastRow, lastRow); 
    }

    public void removeTecnico(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeTecnicos.size()) {
            this.listaDeTecnicos.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public Tecnico getTecnico(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeTecnicos.size()) {
            return listaDeTecnicos.get(rowIndex);
        }
        return null;
    }

    public void setListaDeTecnicos(List<Tecnico> novaLista) {
        this.listaDeTecnicos = novaLista;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: // ID
            case 2: // Idade
                return Integer.class;
            case 1: // Nome
            case 3: // CPF
            case 4: // Login
                return String.class;
            default:
                return Object.class;
        }
    }
}
