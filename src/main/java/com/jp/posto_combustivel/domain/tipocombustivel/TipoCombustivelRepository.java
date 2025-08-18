package com.jp.posto_combustivel.domain.tipocombustivel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivel, Long> {
    boolean existsByNome(String nome);
}
