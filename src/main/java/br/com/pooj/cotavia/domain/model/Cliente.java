package br.com.pooj.cotavia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String documento;
}
