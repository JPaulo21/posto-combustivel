package com.jp.posto_combustivel.domain.tipocombustivel;

import com.jp.posto_combustivel.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {

    private final TipoCombustivelRepository tipoCombustivelRepository;

    @Transactional
    public TipoCombustivel criar(TipoCombustivel tipoCombustivel){
        return tipoCombustivelRepository.save(tipoCombustivel);
    }

    @Transactional(readOnly = true)
    public Page<TipoCombustivel> listarTiposCombustiveisPaginado(Pageable pageable){
        return tipoCombustivelRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public TipoCombustivel buscarPorId(Long id) {
        return tipoCombustivelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não encontrado o tipo de combustível com o ID: " + id));
    }

    @Transactional
    public TipoCombustivel alterar(Long id, TipoCombustivel tipoCombustivelUpdate){
        TipoCombustivel tipoCombustivel = this.buscarPorId(id);
        tipoCombustivel.setNome(tipoCombustivelUpdate.getNome() != null ? tipoCombustivelUpdate.getNome() : tipoCombustivel.getNome());
        tipoCombustivel.setPrecoPorLitro(tipoCombustivelUpdate.getPrecoPorLitro() != null ? tipoCombustivelUpdate.getPrecoPorLitro() : tipoCombustivel.getPrecoPorLitro());
        return tipoCombustivel;
    }

    public void delete(Long id){
        TipoCombustivel tipoCombustivel = this.buscarPorId(id);
        tipoCombustivelRepository.delete(tipoCombustivel);
    }

    public boolean existsByNomeCombustivel(String nome) {
        return tipoCombustivelRepository.existsByNome(nome);
    }

    public boolean existsTipoCombustivelById(Long id) {
        return tipoCombustivelRepository.existsById(id);
    }
}
