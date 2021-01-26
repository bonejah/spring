package br.com.bonejah.feign.demo.feign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import br.com.bonejah.feign.demo.client.ViaCEPClient;
import br.com.bonejah.feign.demo.model.Endereco;

@SpringBootApplication
@EnableFeignClients
public class DemoFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoFeignApplication.class, args);
	}
	
	@Bean()
	public CommandLineRunner run(ViaCEPClient client) {
		return args -> {
			if (args.length > 0) {
				String cep = args[0];
				
				Endereco endereco = client.buscaEnderecoPorCep(cep);
				System.out.println(endereco);
			}
		};
	}

}
