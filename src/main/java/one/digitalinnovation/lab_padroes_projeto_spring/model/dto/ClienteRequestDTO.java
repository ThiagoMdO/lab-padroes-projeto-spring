package one.digitalinnovation.lab_padroes_projeto_spring.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ClienteRequestDTO {
    private String nome;

    private EnderecoRequestDTO enderecoRequestDTO;

}
