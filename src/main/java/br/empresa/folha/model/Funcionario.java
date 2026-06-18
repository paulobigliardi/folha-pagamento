package br.empresa.folha.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import  jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;;
 @Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Nome deve ser obrigatório.")
    @Pattern(regexp = "^\\S+\\s+\\S+.*", message = "Informe nome e sobrenome.")
    @Column(name = "name")
    private String nome;

    @DecimalMin(value = "1621.00", message = "Salário deve ser igual ou maior que o salário mínimo.")
    private Double salario;

    private double imposto;
    private double salarioLiquido;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }
    public double getImposto() {
        return imposto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    } 

}
