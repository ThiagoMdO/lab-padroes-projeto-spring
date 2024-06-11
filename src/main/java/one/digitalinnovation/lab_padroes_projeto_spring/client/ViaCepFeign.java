package one.digitalinnovation.lab_padroes_projeto_spring.client;

import one.digitalinnovation.lab_padroes_projeto_spring.client.models.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepFeign {

    @GetMapping("/{cep}/json")
    Endereco searchLocationByCep(@PathVariable ("cep") String cep);

}
