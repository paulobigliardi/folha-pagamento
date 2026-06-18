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

import br.empresa.folha.model.Gerente;
import br.empresa.folha.repository.GerenteRepository;

@ExtendWith(MockitoExtension.class)
public class GerenteServiceTest {
    @Mock
    GerenteRepository gerenteRepository;

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
}



