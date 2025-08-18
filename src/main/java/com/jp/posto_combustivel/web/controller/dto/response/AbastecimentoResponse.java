package com.jp.posto_combustivel.web.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jp.posto_combustivel.domain.abastecimento.Abastecimento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AbastecimentoResponse(
        Long id,
        String tipoCombustivel,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,
        Double litros,
        BigDecimal valorTotal
) {
    public static AbastecimentoResponse toResponse(Abastecimento abastecimento) {
        return new AbastecimentoResponse(
                abastecimento.getId(),
                abastecimento.getBombaCombustivel().getTipoCombustivel().getNome(),
                abastecimento.getData(),
                abastecimento.getLitros(),
                abastecimento.getValorTotal()
        );
    }
}
