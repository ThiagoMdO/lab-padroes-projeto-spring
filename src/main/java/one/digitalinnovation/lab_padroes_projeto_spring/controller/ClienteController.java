package one.digitalinnovation.lab_padroes_projeto_spring.controller;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteDTO;
import one.digitalinnovation.lab_padroes_projeto_spring.model.dto.ClienteRequestDTO;
import one.digitalinnovation.lab_padroes_projeto_spring.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> mostrarTodosClientes(){
        List<ClienteDTO> clientes = clienteService.getAll();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> mostrarClientePorId(@PathVariable ("id") Long id){
        ClienteDTO clienteDTO = clienteService.getById(id);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        ClienteDTO clienteDTO = clienteService.create(clienteRequestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(clienteDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        ClienteDTO clienteDTO = clienteService.update(id, clienteRequestDTO);

        return ResponseEntity.ok().body(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
