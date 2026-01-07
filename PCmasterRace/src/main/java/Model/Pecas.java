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
    private String codigo; // Novo campo
    private double custo;
    private double preco;
    private int quant;     // Novo campo
    
    // Construtor padrão
    public Pecas() {
        this.ID = 0;
        this.brand = "";
        this.model = "";
        this.condicao = "";
        this.codigo = "";
        this.custo = 0.0;
        this.preco = 0.0;
        this.quant = 0;
    }
    
    // Construtor com parâmetros atualizado
    public Pecas(int ID, String brand, String model, String condicao, String codigo, double custo, double preco, int quant) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.condicao = condicao;
        this.codigo = codigo;
        this.custo = custo;
        this.preco = preco;
        this.quant = quant;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    // Método para calcular o lucro total do estoque da peça
    public double calcularLucro() {
        return (preco - custo) * quant;
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
    
    // Método toString atualizado
    @Override
    public String toString() {
        return "Peça [ID=" + ID + 
               ", Codigo=" + codigo +
               ", Brand=" + brand + 
               ", Model=" + model + 
               ", Qtd=" + quant +
               ", Condição=" + condicao + 
               ", Custo=R$ " + String.format("%.2f", custo) + 
               ", Preço=R$ " + String.format("%.2f", preco) + "]";
    }
    
    // Método para exibir resumo da peça
    public String exibirResumo() {
        return String.format("%s | %s %s (%s) | Qtd: %d | R$ %.2f", 
                            codigo, brand, model, condicao, quant, preco);
    }
}