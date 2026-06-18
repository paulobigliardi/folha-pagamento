package br.empresa.folha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.empresa.folha.model.Funcionario;
import br.empresa.folha.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {
    
    @Mock
    FuncionarioRepository funcionarioRepository;

    @InjectMocks
    FuncionarioService funcionarioService;

    @Test
    void testarListaTodos() {
        List<Funcionario> lista = new ArrayList<>();
        lista.add(new Funcionario());
        when(funcionarioRepository.findAll()).thenReturn(lista);

        List<Funcionario> resultado = funcionarioService.listarTodos();

        assertEquals(1, resultado.size());
    }
}
