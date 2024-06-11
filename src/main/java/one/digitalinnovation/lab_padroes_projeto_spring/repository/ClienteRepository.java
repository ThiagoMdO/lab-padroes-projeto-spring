package one.digitalinnovation.lab_padroes_projeto_spring.repository;

import one.digitalinnovation.lab_padroes_projeto_spring.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
