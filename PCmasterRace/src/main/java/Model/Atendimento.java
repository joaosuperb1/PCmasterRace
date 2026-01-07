/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author superbi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Atendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    protected String data_atendimento;
    
    
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    protected Tecnico tecnico;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private String preco;
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "atendimento_pecas",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "pecas_id"))
    private List<Pecas> pecasUtilizadas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "atendimento_dispositivos",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_id"))
    private List<Dispositivos> dispositivosEnvolvidos = new ArrayList<>();

    // Getters e Setters para as listas
    public List<Pecas> getPecasUtilizadas() {
        return pecasUtilizadas;
    }

    public void setPecasUtilizadas(List<Pecas> pecasUtilizadas) {
        this.pecasUtilizadas = pecasUtilizadas;
    }

    public void addPeca(Pecas peca) {
        this.pecasUtilizadas.add(peca);
    }

    public List<Dispositivos> getDispositivosEnvolvidos() {
        return dispositivosEnvolvidos;
    }

    public void setDispositivosEnvolvidos(List<Dispositivos> dispositivosEnvolvidos) {
        this.dispositivosEnvolvidos = dispositivosEnvolvidos;
    }
    
    public void addDispositivo(Dispositivos dispositivo) {
        this.dispositivosEnvolvidos.add(dispositivo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(String data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", data_atendimento=" + data_atendimento + ", tecnico=" + tecnico + ", status=" + status + ", cliente=" + cliente + ", preco=" + preco + ", descricao=" + descricao + '}';
    }
    

    
    
}
