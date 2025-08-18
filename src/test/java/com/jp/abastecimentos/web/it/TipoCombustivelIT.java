package com.jp.abastecimentos.web.it;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@ActiveProfiles("it")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TipoCombustivelIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void criarTipoCombustivel_retonarResponse201TipoCombustivel() {
        TipoCombustivel tipoCombustivel = webTestClient
                .post()
                .uri("/v1/tipos-combustivel")
                .contentType(APPLICATION_JSON)
                .bodyValue(new TipoCombustivel("Gasolina", BigDecimal.valueOf(6.71)))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(TipoCombustivel.class)
                .returnResult().getResponseBody();

        assertThat(tipoCombustivel).isNotNull();
        assertThat(tipoCombustivel.getNome()).isEqualTo("Gasolina");
        assertThat(tipoCombustivel.getPrecoPorLitro()).isEqualTo(BigDecimal.valueOf(6.71));
    }
}
