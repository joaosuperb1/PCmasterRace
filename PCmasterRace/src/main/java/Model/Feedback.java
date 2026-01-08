/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 *
 * @author superbi
 */
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comentario;

    // --- MUDANÇA PRINCIPAL AQUI ---
    // Removemos @OneToOne com Atendimento
    // Adicionamos @ManyToOne com Cliente (Um cliente pode ter vários feedbacks)
    @ManyToOne 
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente;

    public Feedback() {
    }

    public Feedback(String comentario, Cliente cliente) {
        this.comentario = comentario;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // --- GETTER E SETTER DO CLIENTE ---
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        // Ajustei para imprimir o nome do cliente, evitando erros se o objeto for nulo
        String nomeCliente = (cliente != null) ? cliente.getNome() : "Desconhecido";
        return "Feedback{" + "id=" + id + ", comentario=" + comentario + ", cliente=" + nomeCliente + '}';
    }
}