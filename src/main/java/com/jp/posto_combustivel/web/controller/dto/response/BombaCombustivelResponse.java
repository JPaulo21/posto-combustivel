package com.jp.posto_combustivel.web.controller.dto.response;

import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;

public record BombaCombustivelResponse(
        Long id,
        String nome,
        String tipoCombustivel
) {
    public static BombaCombustivelResponse toResponse(BombaCombustivel bombaCombustivel) {
        return new BombaCombustivelResponse(
                bombaCombustivel.getId(),
                bombaCombustivel.getNome(),
                bombaCombustivel.getTipoCombustivel().getNome()
        );
    }
}
