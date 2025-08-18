package com.jp.posto_combustivel.web.controller.dto.request;

import com.jp.posto_combustivel.domain.abastecimento.Abastecimento;
import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AbastecimentoRequest(
        @NotNull(message = "O campo 'idBombaCombustivel' é obrigatório")
        @Schema(description = "ID da bomba de combustível", example = "1")
        Long idBombaCombustivel,
        @NotNull(message = "O campo 'litros' é obrigatório")
        @Schema(description = "Quantidade de litros abastecidos", example = "5.0")
        Double litros
) {
    public Abastecimento toEntity() {
        return Abastecimento.builder()
                .bombaCombustivel(BombaCombustivel.builder()
                        .id(idBombaCombustivel)
                        .build())
                .litros(litros)
                .build();
    }
}
