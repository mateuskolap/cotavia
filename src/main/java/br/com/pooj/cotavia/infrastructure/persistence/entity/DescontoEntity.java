package br.com.pooj.cotavia.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_desconto")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DescontoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valorDesconto;

    @Column(nullable = false)
    private LocalDateTime dataAplicacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cotacao_id", nullable = false)
    private CotacaoEntity cotacao;
}
