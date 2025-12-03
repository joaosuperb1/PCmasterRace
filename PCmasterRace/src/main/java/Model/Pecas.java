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

/**
 *
 * @author superbi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pecas {
    // Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String brand;
    private String model;
    private String condicao;
    private double custo;
    private double preco;
    
    // Construtor padrão
    public Pecas() {
        this.ID = 0;
        this.brand = "";
        this.condicao = "";
        this.custo = 0.0;
        this.preco = 0.0;
    }
    
    // Construtor com parâmetros
    public Pecas(int ID, String brand, String model, String condicao, double custo, double preco) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.condicao = condicao;
        this.custo = custo;
        this.preco = preco;
    }
    
    // Getters e Setters
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getCondicao() {
        return condicao;
    }
    
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
    
    public double getCusto() {
        return custo;
    }
    
    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    // Método para calcular o lucro da peça
    public double calcularLucro() {
        return preco - custo;
    }
    
    // Método para calcular a margem de lucro em porcentagem
    public double calcularMargemLucro() {
        if (custo == 0) {
            return 0;
        }
        return ((preco - custo) / custo) * 100;
    }
    
    // Método para verificar se a peça é nova
    public boolean isNova() {
        return "Nova".equalsIgnoreCase(condicao);
    }
    
    // Método para verificar se a peça é usada
    public boolean isUsada() {
        return "Usada".equalsIgnoreCase(condicao);
    }
    
    // Método para aplicar desconto no preço
    public void aplicarDesconto(double percentualDesconto) {
        if (percentualDesconto > 0 && percentualDesconto <= 100) {
            double desconto = preco * (percentualDesconto / 100);
            preco -= desconto;
        }
    }
    
    // Método para atualizar preço baseado no custo com uma margem
    public void atualizarPrecoComMargem(double margemPercentual) {
        if (margemPercentual >= 0) {
            preco = custo * (1 + margemPercentual / 100);
        }
    }
    
    // Método toString para exibir informações da peça
    @Override
    public String toString() {
        return "Peça [ID=" + ID + 
               ", Brand=" + brand + 
               ", Model=" + model + 
               ", Condição=" + condicao + 
               ", Custo=R$ " + String.format("%.2f", custo) + 
               ", Preço=R$ " + String.format("%.2f", preco) + 
               ", Lucro=R$ " + String.format("%.2f", calcularLucro()) + "]";
    }
    
    // Método para exibir resumo da peça
    public String exibirResumo() {
        return String.format("ID: %d | %s %s | %s | Preço: R$ %.2f", 
                            ID, brand, model, condicao, preco);
    }
}
