/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author superbi
 */
public class TMcadCliente extends AbstractTableModel {

    /**
     * Lista de clientes que serão exibidos na tabela.
     */
    private List<Cliente> listaDeClientes;

    /**
     * Define os nomes (cabeçalhos) das colunas da tabela.
     */
    private final String[] colunas = {"ID", "Nome", "Idade", "CPF", "Login"};

    /**
     * Construtor padrão. Inicializa com uma lista vazia.
     */
    public TMcadCliente() {
        this.listaDeClientes = new ArrayList<>();
    }

    /**
     * Construtor que já recebe a lista de clientes.
     * @param listaDeClientes Lista de clientes a ser exibida.
     */
    public TMcadCliente(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    // --- Métodos Essenciais do AbstractTableModel ---

    /**
     * Retorna o número de linhas na tabela (que é o tamanho da lista de clientes).
     */
    @Override
    public int getRowCount() {
        return listaDeClientes.size();
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
        // Pega o cliente para a linha específica
        Cliente cliente = listaDeClientes.get(rowIndex);

        // Retorna o atributo do cliente com base no índice da coluna
        // **IMPORTANTE:** Isso assume que sua classe User/Cliente tem getters públicos!
        // Ex: public int getId() { return this.id; }
        switch (columnIndex) {
            case 0: // Coluna "ID"
                return cliente.getId();
            case 1: // Coluna "Nome"
                return cliente.getNome();
            case 2: // Coluna "Idade"
                return cliente.getIdade();
            case 3: // Coluna "CPF"
                return cliente.getCpf();
            case 4: // Coluna "Login"
                return cliente.getLogin();
            default:
                // Retorna null se o índice da coluna for inválido
                return null;
        }
    }

    // --- Métodos Auxiliares para Manipular a Lista ---

    /**
     * Adiciona um cliente ao final da lista e notifica a JTable.
     * @param cliente O cliente a ser adicionado.
     */
    public void addCliente(Cliente cliente) {
        this.listaDeClientes.add(cliente);
        // Notifica a tabela que uma nova linha foi inserida na última posição
        int lastRow = getRowCount() - 1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    /**
     * Remove um cliente da lista com base no índice (linha) e notifica a JTable.
     * @param rowIndex O índice da linha a ser removida.
     */
    public void removeCliente(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeClientes.size()) {
            this.listaDeClientes.remove(rowIndex);
            // Notifica a tabela que a linha foi removida
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    /**
     * Retorna o objeto Cliente da linha especificada.
     * Útil para quando o usuário seleciona uma linha e você precisa dos dados.
     * @param rowIndex O índice da linha.
     * @return O objeto Cliente.
     */
    public Cliente getCliente(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaDeClientes.size()) {
            return listaDeClientes.get(rowIndex);
        }
        return null;
    }

    /**
     * Atualiza toda a lista de clientes e notifica a JTable para redesenhar tudo.
     * @param novaLista A nova lista de clientes.
     */
    public void setListaDeClientes(List<Cliente> novaLista) {
        this.listaDeClientes = novaLista;
        // Notifica a tabela que todos os dados mudaram
        fireTableDataChanged();
    }

    /**
     * Controla se as células da tabela são editáveis.
     * Por padrão, é melhor que não sejam editáveis diretamente pela tabela.
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Ajuda a JTable a usar o renderizador correto para cada tipo de dado.
     * (Números alinhados à direita, Strings à esquerda, etc.)
     */
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