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
public class Dispositivos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String brand;
    private String model;
    private String codigo;
    private double custo;
    private double preco;
    private int quant;

    public Dispositivos() {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.codigo = "";
        this.custo = 0.0;
        this.preco = 0.0;
        this.quant = 0;
    }
    
    public Dispositivos(int id, String brand, String model, String codigo, double custo, double preco, int quant) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.codigo = codigo;
        this.custo = custo;
        this.preco = preco;
        this.quant = quant;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
    
    public void setQuant(int quant){
        this.quant = quant;
    }
    
    public int getQuant(){
        return quant;
    }
    
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
        return "Dispositivos{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", codigo=" + codigo + ", custo=" + custo + ", preco=" + preco + ", quant=" + quant + '}';
    }
    
    
    // Método para exibir resumo da peça
    public String exibirResumo() {
        return String.format("ID: %d | %s %s | %s | Preço: R$ %.2f", 
                            id, brand, model, codigo, preco);
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
