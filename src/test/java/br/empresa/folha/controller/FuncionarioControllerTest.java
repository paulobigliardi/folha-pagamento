package br.empresa.folha.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.empresa.folha.service.FuncionarioService;

@WebMvcTest(FuncionarioController.class)
public class FuncionarioControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    FuncionarioService funcionarioService;

    @Test
    void testarListaTodos() throws Exception {
        mockMvc.perform(get("/funcionarios"))
                   .andExpect(status().isOk());
    }
}
