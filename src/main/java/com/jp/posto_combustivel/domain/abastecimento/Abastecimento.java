package com.jp.posto_combustivel.domain.abastecimento;

import com.jp.posto_combustivel.domain.bombacombustivel.BombaCombustivel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ABASTECIMENTO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Builder
public class Abastecimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bomba_combustivel")
    private BombaCombustivel bombaCombustivel;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "litros", nullable = false)
    private Double litros;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;
}
