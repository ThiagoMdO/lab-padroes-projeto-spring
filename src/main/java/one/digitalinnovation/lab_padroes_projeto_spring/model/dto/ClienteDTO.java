package one.digitalinnovation.lab_padroes_projeto_spring.model.dto;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.lab_padroes_projeto_spring.client.models.Endereco;
import one.digitalinnovation.lab_padroes_projeto_spring.model.entities.Cliente;

@Getter
@Setter
public class ClienteDTO {
    private Long id;

    private String nome;

    private Endereco endereco;

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
    }
}
