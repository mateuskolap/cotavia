package br.com.pooj.cotavia.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.domain.enums.StatusCotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cotacao {
    private Long id;
    private BigDecimal valorPago;
    private StatusCotacao status;
    private LocalDateTime dataPagamento;
    private Cliente cliente;
    private Destino destino;
}