package one.digitalinnovation.lab_padroes_projeto_spring.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.digitalinnovation.lab_padroes_projeto_spring.client.models.Endereco;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteDTO;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteRequestDTO;

@Entity
@Getter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Embedded
    private Endereco endereco;

    public Cliente(ClienteRequestDTO requestDTO, Endereco endereco){
        nome = requestDTO.getNome();
        this.endereco = endereco;
    }

    public Cliente(ClienteDTO clienteDTO){
        id = clienteDTO.getId();
        nome = clienteDTO.getNome();
        endereco = clienteDTO.getEndereco();
    }
}
