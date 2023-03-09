package com.br.globalfinanceiro.vendas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.globalfinanceiro.vendas.Annotations.Animal;
import com.br.globalfinanceiro.vendas.Annotations.Cachorro;
import com.br.globalfinanceiro.vendas.Annotations.Gato;

@SpringBootApplication
@RestController

public class VendasApplication {

	@Value("${spring.application.name}")
	private String applicationName;


	@Cachorro
	private Animal animal;

	@Bean(name ="executarAnimal")
	public CommandLineRunner executar(){
		return (args) -> {
            this.animal.fazerBarulho();
        };
	}

	@GetMapping("/hello")
	public String heelloWorld() {
		return applicationName;

	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
