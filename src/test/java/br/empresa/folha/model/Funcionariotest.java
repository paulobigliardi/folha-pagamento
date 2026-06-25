package br.empresa.folha.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioTest {

    @Test
    void testeSetGetSalario() {
        Funcionario f = new Funcionario();
        f.setSalario(2600.0);
        assertEquals(2600.0, f.getSalario());
    }

    @Test
    void testeSetGetImposto() {
        Funcionario f = new Funcionario();
        f.setImposto(209.685);
        assertEquals(209.685, f.getImposto());
    }
}
