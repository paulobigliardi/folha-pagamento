package br.empresa.folha.model;

import jakarta.persistence.Entity;


 @Entity
public class Gerente extends Funcionario {
     private double bonus;
    public Gerente () {
       
    }
    public double getBonus(){
        return this.bonus;
    }
    
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalarioLiquido() {
        return super.getSalarioLiquido() + this.bonus;
    }
}
