package com.jp.posto_combustivel.domain.abastecimento;

import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;
import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivelService;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaCombustivelService bombaCombustivelService;
    private final TipoCombustivelService tipoCombustivelService;

    public Abastecimento abastecer(Abastecimento abastecimento) {
        BombaCombustivel bombaCombustivel = bombaCombustivelService.buscarPorId(abastecimento.getBombaCombustivel().getId());

        TipoCombustivel tipoCombustivel = tipoCombustivelService.buscarPorId(bombaCombustivel.getTipoCombustivel().getId());
        BigDecimal valorTotal = tipoCombustivel.getPrecoPorLitro().multiply(BigDecimal.valueOf(abastecimento.getLitros()));

        abastecimento.setBombaCombustivel(bombaCombustivel);
        abastecimento.setValorTotal(valorTotal);
        abastecimento.setData(LocalDate.now());
        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento buscarPorId(Long id) {
        return abastecimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento com id " + id + " não encontrado!"));
    }
}
