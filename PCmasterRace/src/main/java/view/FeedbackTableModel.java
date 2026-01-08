/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import Model.Feedback;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author superbi
 */
public class FeedbackTableModel extends AbstractTableModel {

    private List<Feedback> lista;
    // Novas Colunas: ID, Cliente, Comentário (Removemos Técnico e Data)
    private String[] colunas = {"ID", "Cliente", "Comentário"};

    public FeedbackTableModel(List<Feedback> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Feedback f = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return f.getId();
            case 1: return f.getCliente().getNome(); // Pega nome direto do cliente
            case 2: return f.getComentario();
            default: return "";
        }
    }
    
    public void setLista(List<Feedback> novaLista) {
        this.lista = novaLista;
        fireTableDataChanged();
    }
    
    public Feedback getFeedbackAt(int linha) {
        return lista.get(linha);
    }
}