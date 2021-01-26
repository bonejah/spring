package br.com.bonejah.feign.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bonejah.feign.demo.model.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface ViaCEPClient {

	 @GetMapping("{cep}/json")
	  Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
	
}
