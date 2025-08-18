package com.jp.posto_combustivel.domain.bombacombustivel;

import com.jp.posto_combustivel.domain.tipocombustivel.TipoCombustivel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOMBA_COMBUSTIVEL")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class BombaCombustivel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_combustivel", nullable = false)
    private TipoCombustivel tipoCombustivel;
}
