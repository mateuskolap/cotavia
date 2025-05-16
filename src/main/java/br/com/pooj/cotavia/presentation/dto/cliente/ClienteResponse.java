package br.com.pooj.cotavia.presentation.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String documento;
}
