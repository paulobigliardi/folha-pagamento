package br.empresa.folha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.empresa.folha.model.Funcionario;
import br.empresa.folha.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceTest {

    @Mock
    FuncionarioRepository funcionarioRepository;

    @InjectMocks
    FuncionarioService funcionarioService;

    @Test
    void testeDescontoINSS() {
        Funcionario f = new Funcionario();
        f.setSalario(2600.0);
        when(funcionarioRepository.findAll()).thenReturn(List.of(f));

        funcionarioService.descontoINSS();

        assertEquals(209.685, f.getImposto(), 0.001);
    }
}
