package br.empresa.folha.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GerenteTest {

    @Test
    void testeBonus() {
        Gerente gerente = new Gerente();
        gerente.setBonus(1200.0);
        assertEquals(1200.0, gerente.getBonus());
    }

    @Test
    void testeSalarioLiquidoIncluiBonus() {
        Gerente gerente = new Gerente();
        gerente.setSalarioLiquido(4000.0);
        gerente.setBonus(1200.0);
        assertEquals(5200.0, gerente.getSalarioLiquido());
    }
}
