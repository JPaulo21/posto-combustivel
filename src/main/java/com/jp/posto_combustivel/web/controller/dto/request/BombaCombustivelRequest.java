package com.jp.posto_combustivel.web.controller.dto.request;

import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "BombaCombustivelRequest", description = "Representa o payload para criação de uma nova bomba de combustível")
public record BombaCombustivelRequest(
        @Schema(description = "Nome da bomba de combustível", example = "Bomba 1")
        String nome,
        @Schema(description = "Id do tipo de combustível da bomba", example = "1")
        Long idTipoCombustivel
) {
    public BombaCombustivel toEntity() {
        return BombaCombustivel.builder()
                .nome(this.nome)
                .tipoCombustivel(TipoCombustivel.builder()
                        .id(idTipoCombustivel)
                        .build())
                .build();
    }
}
