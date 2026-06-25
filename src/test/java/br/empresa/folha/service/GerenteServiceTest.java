package br.empresa.folha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.empresa.folha.model.Gerente;
import br.empresa.folha.repository.GerenteRepository;

@ExtendWith(MockitoExtension.class)
public class GerenteServiceTest {

    @Mock
    GerenteRepository gerenteRepository;

    @Mock
    FuncionarioService funcionarioService;

    @InjectMocks
    GerenteService gerenteService;

    @Test
    void testarListaTodos() {
        List<Gerente> lista = new ArrayList<>();
        lista.add(new Gerente());
        when(gerenteRepository.findAll()).thenReturn(lista);

        List<Gerente> resultado = gerenteService.listarTodos();

        assertEquals(1, resultado.size());
    }

    @Test
    void testeDescontoINSS() {
        Gerente gerente = new Gerente();
        gerente.setSalario(5000.0);
        when(gerenteRepository.findAll()).thenReturn(List.of(gerente));
        when(funcionarioService.salarioLiquido(anyDouble(), anyDouble(), anyDouble()))
            .thenAnswer(inv -> (Double) inv.getArgument(0) - (Double) inv.getArgument(1));

        gerenteService.descontoINSS();

        assertEquals(501.514, gerente.getImposto(), 0.001);
        assertEquals(4498.486, gerente.getSalarioLiquido(), 0.001);
    }
}
