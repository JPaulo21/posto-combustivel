package com.jp.posto_combustivel.web.controller.dto.response;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;

public record TipoCombustivelResponse(
        Long id,
        String nome,
        String precoPorLitro
) {
    public static TipoCombustivelResponse toResponse(TipoCombustivel tipoCombustivel) {
        return new TipoCombustivelResponse(
                tipoCombustivel.getId(),
                tipoCombustivel.getNome(),
                tipoCombustivel.getPrecoPorLitro().toString()
        );
    }
}
