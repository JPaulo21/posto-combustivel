package com.jp.abastecimentos.web.controller;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivelService;
import com.jp.posto_combustivel.web.controller.TipoCombustivelController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TipoCombustivelController.class)
public class TipoCombustivelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TipoCombustivelService tipoCombustivelService;

    @Test
    void criarTipoCombustivel_comDadosValidos_retonarResponse201TipoCombustivel() throws Exception {
        when(tipoCombustivelService.criar(any(TipoCombustivel.class)))
                .thenReturn(new TipoCombustivel("Gasolina", BigDecimal.valueOf(6.71)));

        mockMvc.perform(post("/v1/tipos-combustivel")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "nome": "Gasolina",
                                    "precoPorLitro": 6.71
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Gasolina"))
                .andExpect(jsonPath("$.precoPorLitro").value(6.71));
    }
}
