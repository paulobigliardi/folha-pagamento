package br.empresa.folha.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.empresa.folha.service.FuncionarioService;

class FuncionarioTest{
@Test
void testeImposto() {
    Funcionario f = new Funcionario();
    f.setSalario(2600.0);
    FuncionarioService service = new FuncionarioService();
    service.calcular(f);
    assertEquals(234.0, f.getImposto());
}
@Test
void testeSalarioLiquido() {
    Funcionario f = new Funcionario();
    f.setSalario(2600.0);
    FuncionarioService service = new FuncionarioService();
    service.calcular(f);
    assertEquals(2366.0, f.getSalarioLiquido());
}
}