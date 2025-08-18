package com.jp.posto_combustivel.domain.bombacombustivel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaCombustivelRepository extends JpaRepository<BombaCombustivel, Long> {
}
