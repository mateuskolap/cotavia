package br.com.pooj.cotavia.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.domain.enums.StatusPagamentoEnum;


@Entity
@Table(name = "tb_pagamento")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamentoEnum status;

    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cotacao_id", nullable = false)
    private CotacaoEntity cotacao;
}
