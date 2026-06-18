package br.empresa.folha.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.empresa.folha.service.GerenteService;

@WebMvcTest(GerenteController.class)
public class GerenteControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GerenteService gerenteService;

    @Test
    void testarListaTodos() throws Exception {
        mockMvc.perform(get("/gerentes"))
                .andExpect(status().isOk());
    } 
}
