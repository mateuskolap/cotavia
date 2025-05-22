package br.com.pooj.cotavia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.domain.enums.StatusPagamentoEnum;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pagamento {
    private Long id;
    private BigDecimal valorPago;
    private StatusPagamentoEnum status;
    private LocalDateTime dataPagamento;
    private Cotacao cotacao;
}
