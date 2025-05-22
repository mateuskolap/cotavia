package br.com.pooj.cotavia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Gerter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Pagamento {
    private Long id;
    private BigDecimal valorPago;
    private String status;
    private String dataPagamento;
    private Cotacao cotacao;
}
