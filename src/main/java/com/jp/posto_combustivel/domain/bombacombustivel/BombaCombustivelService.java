package com.jp.posto_combustivel.domain.bombacombustivel;

import com.jp.posto_combustivel.domain.exceptions.NotFoundException;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivelRepository;
import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BombaCombustivelService {

    private final BombaCombustivelRepository bombaCombustivelRepository;
    private final TipoCombustivelService tipoCombustivelService;

    public BombaCombustivel buscarPorId(Long id) {
        return bombaCombustivelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bomba de combustível não encontrada com o ID: " + id));
    }

    public BombaCombustivel salvar(BombaCombustivel bombaCombustivel) {
        TipoCombustivel tipoCombustivel = tipoCombustivelService.buscarPorId(bombaCombustivel.getTipoCombustivel().getId());
        bombaCombustivel.setTipoCombustivel(tipoCombustivel);
        return bombaCombustivelRepository.save(bombaCombustivel);
    }

    public void deletar(Long id) {
        BombaCombustivel bombaCombustivel = buscarPorId(id);
        bombaCombustivelRepository.delete(bombaCombustivel);
    }

    public Page<BombaCombustivel> listarBombasPaginado(Pageable pageable) {
        return bombaCombustivelRepository.findAll(pageable);
    }

}