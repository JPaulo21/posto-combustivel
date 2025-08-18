package com.jp.posto_combustivel.domain.tipocombustivel;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TIPO_COMBUSTIVEL")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoCombustivel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "preco_por_litro", nullable = false)
    private BigDecimal precoPorLitro;

    public TipoCombustivel(String nome, BigDecimal precoPorLitro) {
        this.nome = nome;
        this.precoPorLitro = precoPorLitro;
    }

}
