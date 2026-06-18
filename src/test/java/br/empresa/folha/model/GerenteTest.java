package br.empresa.folha.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import br.empresa.folha.service.FuncionarioService;


public class GerenteTest {
     FuncionarioService funcionarioService = new FuncionarioService();

    @Test
void testeImposto() {
    
    
    Gerente gerente = new Gerente();
    gerente.setSalario(5000.0);
    funcionarioService.calcular(gerente);
    assertEquals(450.0, gerente.getImposto());
}

    @Test
    void testeBonus() {
        Gerente gerente = new Gerente();
        gerente.setSalario(5000.0);
        gerente.setBonus(1200.0);
        assertEquals(1200, gerente.getBonus());
    }

    @Test
    void testeSalarioLiquido() {
        Gerente gerente = new Gerente();
        gerente.setSalario(5000.0);
        gerente.setBonus(1200.0);
        funcionarioService.calcular(gerente);
        assertEquals(5750.0, gerente.getSalarioLiquido());
    }
}
