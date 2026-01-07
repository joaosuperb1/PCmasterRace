/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

// Importações necessárias (assumindo que estão no pacote Model)
import Model.Dispositivos;
import Model.Pecas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author superbi
 */
public class TMcadEstoque extends AbstractTableModel {

    /**
     * Lista genérica para guardar Dispositivos OU Peças.
     */
    private List<Object> listaDeEstoque;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     * Atualizado para incluir Código e Quantidade.
     */
    private final String[] colunas = {"ID", "Código", "Marca", "Modelo", "Qtd", "Condição", "Custo", "Preço"};

    /**
     * Construtor padrão.
     */
    public TMcadEstoque() {
        this.listaDeEstoque = new ArrayList<>();
    }

    /**
     * Construtor que recebe a lista.
     */
    public TMcadEstoque(List<?> listaDeItens) {
        this.listaDeEstoque = new ArrayList<>(listaDeItens);
    }

    // --- Métodos Essenciais do AbstractTableModel ---

    @Override
    public int getRowCount() {
        return listaDeEstoque.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object item = listaDeEstoque.get(rowIndex);

        // Verifica se é um Dispositivo
        if (item instanceof Dispositivos) {
            Dispositivos d = (Dispositivos) item;
            switch (columnIndex) {
                case 0: return d.getId();      // Atenção: Dispositivos usa getId()
                case 1: return d.getCodigo();
                case 2: return d.getBrand();
                case 3: return d.getModel();
                case 4: return d.getQuant();
                case 5: return "-";            // Dispositivos não têm condição armazenada neste modelo
                case 6: return d.getCusto();
                case 7: return d.getPreco();
                default: return null;
            }
        } 
        // Verifica se é uma Peça
        else if (item instanceof Pecas) {
            Pecas p = (Pecas) item;
            switch (columnIndex) {
                case 0: return p.getID();      // Atenção: Peças usa getID()
                case 1: return p.getCodigo();
                case 2: return p.getBrand();
                case 3: return p.getModel();
                case 4: return p.getQuant();
                case 5: return p.getCondicao(); // Peças têm condição (Novo/Usado)
                case 6: return p.getCusto();
                case 7: return p.getPreco();
                default: return null;
            }
        }

        return null;
    }

    // --- Métodos Auxiliares ---

    public void addItem(Object item) {
        if (item instanceof Dispositivos || item instanceof Pecas) {
            this.listaDeEstoque.add(item);
            int lastRow = getRowCount() - 1;
            fireTableRowsInserted(lastRow, lastRow);
        }
    }

    public void removeItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeEstoque.size()) {
            this.listaDeEstoque.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public Object getItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeEstoque.size()) {
            return listaDeEstoque.get(rowIndex);
        }
        return null;
    }

    public void setLista(List<?> novaLista) {
        this.listaDeEstoque = new ArrayList<>(novaLista);
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
            case 4: // Qtd
                return Integer.class;
            case 1: // Código
            case 2: // Marca
            case 3: // Modelo
            case 5: // Condição
                return String.class;
            case 6: // Custo
            case 7: // Preço
                return Double.class;
            default:
                return Object.class;
        }
    }
}