package br.com.pooj.cotavia.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.domain.enums.StatusCotacaoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cotacao")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CotacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorPago;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCotacaoEnum status;
    
    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destino_id", nullable = false)
    private DestinoEntity destino;
}
