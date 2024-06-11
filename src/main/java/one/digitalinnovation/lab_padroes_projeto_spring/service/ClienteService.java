package one.digitalinnovation.lab_padroes_projeto_spring.service;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.lab_padroes_projeto_spring.client.ViaCepFeign;
import one.digitalinnovation.lab_padroes_projeto_spring.client.models.Endereco;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteDTO;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteRequestDTO;
import one.digitalinnovation.lab_padroes_projeto_spring.model.entities.Cliente;
import one.digitalinnovation.lab_padroes_projeto_spring.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    final ClienteRepository clienteRepository;

    final ViaCepFeign cepFeign;

    public List<ClienteDTO> getAll(){
        List<ClienteDTO> list = new ArrayList<>();
        for (Cliente cliente : clienteRepository.findAll()){
            list.add(new ClienteDTO(cliente));
        }
        return list;
    }

    public ClienteDTO getById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO create(ClienteRequestDTO requestDTO){

        return salvarCliente(requestDTO);
    }

    public ClienteDTO update(Long id, ClienteRequestDTO clienteRequestDTO){
        ClienteDTO byId = getById(id);

        Endereco endereco = procurarCep(clienteRequestDTO.getEnderecoRequestDTO().getCep());

        byId.setNome(clienteRequestDTO.getNome());
        byId.setEndereco(endereco);

        Cliente cliente = clienteRepository.save(new Cliente(byId));

        return new ClienteDTO(cliente);
    }

    public void delete(Long id){
        ClienteDTO byId = getById(id);
        clienteRepository.delete(new Cliente(byId));
    }

    private ClienteDTO salvarCliente(ClienteRequestDTO requestDTO) {
        Endereco endereco = procurarCep(requestDTO.getEnderecoRequestDTO().getCep());

        Cliente cliente = new Cliente(requestDTO, endereco);

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);
    }

    private Endereco procurarCep(String cep) {
        Endereco endereco = cepFeign.searchLocationByCep(cep);
        return endereco;
    }


}
