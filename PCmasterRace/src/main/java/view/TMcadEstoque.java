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
     * Usamos List<Object> para manter os métodos add/remove do template.
     */
    private List<Object> listaDeEstoque;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     * (Assumindo que ambas as classes têm atributos equivalentes)
     */
    private final String[] colunas = {"ID", "Marca", "Modelo", "Condição", "Custo", "Preço"};

    /**
     * Construtor padrão. Inicializa com uma lista vazia.
     */
    public TMcadEstoque() {
        this.listaDeEstoque = new ArrayList<>();
    }

    /**
     * Construtor que já recebe a lista de itens.
     * Usa List<?> (wildcard) para aceitar List<Dispositivos> ou List<Pecas>.
     * @param listaDeItens Lista de itens a ser exibida.
     */
    public TMcadEstoque(List<?> listaDeItens) {
        // Converte a lista recebida para uma List<Object> interna
        this.listaDeEstoque = new ArrayList<>(listaDeItens);
    }
    
    
    

    // --- Métodos Essenciais do AbstractTableModel ---

    /**
     * Retorna o número de linhas na tabela (tamanho da lista).
     */
    @Override
    public int getRowCount() {
        return listaDeEstoque.size();
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
        // Pega o item genérico para a linha específica
        Object item = listaDeEstoque.get(rowIndex);

        // Verifica se é um Dispositivo
        if (item instanceof Dispositivos) {
            Dispositivos d = (Dispositivos) item;
            // **IMPORTANTE:** Requer getters públicos na classe Dispositivos!
            // (ex: getId(), getBrand(), getModel(), getCondicao(), getCusto(), getPreco())
            switch (columnIndex) {
                case 0: return d.getID();
                case 1: return d.getBrand();
                case 2: return d.getModel();
                case 3: return d.getCondicao();
                case 4: return d.getCusto();
                case 5: return d.getPreco();
                default: return null;
            }
        } 
        // Verifica se é uma Peça
        else if (item instanceof Pecas) {
            Pecas p = (Pecas) item;
            // **IMPORTANTE:** Requer getters públicos na classe Pecas!
            // (ex: getId(), getBrand(), getModel(), getCondicao(), getCusto(), getPreco())
             switch (columnIndex) {
                case 0: return p.getID(); // Assumindo getId()
                case 1: return p.getBrand();
                case 2: return p.getModel();
                case 3: return p.getCondicao();
                case 4: return p.getCusto();
                case 5: return p.getPreco();
                default: return null;
            }
        }

        // Retorna null se o tipo de objeto não for reconhecido
        return null;
    }

    // --- Métodos Auxiliares para Manipular a Lista (similares ao template) ---

    /**
     * Adiciona um item (Dispositivo ou Peça) ao final da lista e notifica a JTable.
     * @param item O item a ser adicionado.
     */
    public void addItem(Object item) {
        // Apenas adiciona se for um tipo esperado
        if (item instanceof Dispositivos || item instanceof Pecas) {
            this.listaDeEstoque.add(item);
            int lastRow = getRowCount() - 1;
            fireTableRowsInserted(lastRow, lastRow);
        }
    }

    /**
     * Remove um item da lista com base no índice (linha) e notifica a JTable.
     * @param rowIndex O índice da linha a ser removida.
     */
    public void removeItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeEstoque.size()) {
            this.listaDeEstoque.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    /**
     * Retorna o objeto (Dispositivo ou Peça) da linha especificada.
     * @param rowIndex O índice da linha.
     * @return O objeto (genérico).
     */
    public Object getItem(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeEstoque.size()) {
            return listaDeEstoque.get(rowIndex);
        }
        return null;
    }

    /**
     * Atualiza toda a lista de itens e notifica a JTable para redesenhar.
     * @param novaLista A nova lista (pode ser List<Dispositivos> ou List<Pecas>).
     */
    public void setLista(List<?> novaLista) {
        this.listaDeEstoque = new ArrayList<>(novaLista);
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
            case 1: // Marca
            case 2: // Modelo
            case 3: // Condição
                return String.class;
            case 4: // Custo
            case 5: // Preço
                return Double.class;
            default:
                return Object.class;
        }
    }
}