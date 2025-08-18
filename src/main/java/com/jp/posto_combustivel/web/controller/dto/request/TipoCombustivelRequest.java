package com.jp.posto_combustivel.web.controller.dto.request;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(name = "TipoCombustivelRequest", description = "Representa o payload para criação de um novo tipo de combustível")
public record TipoCombustivelRequest(
        @Schema(description = "Nome do tipo de combustível", example = "Gasolina Comum")
        String nome,
        @Schema(description = "Preço por litro do combustível", example = "5.79")
        BigDecimal precoPorLitro
) {
    public TipoCombustivel toEntity() {
        TipoCombustivel tipoCombustivel = new TipoCombustivel();
        tipoCombustivel.setNome(nome);
        tipoCombustivel.setPrecoPorLitro(precoPorLitro);
        return tipoCombustivel;
    }

}
