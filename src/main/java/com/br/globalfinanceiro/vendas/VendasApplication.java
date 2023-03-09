package com.br.globalfinanceiro.vendas;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.br.globalfinanceiro.vendas.domain.Cliente;
import com.br.globalfinanceiro.vendas.repositorio.Clientes;

@SpringBootApplication
@RestController

public class VendasApplication{

	@Bean
	public CommandLineRunner init (@Autowired Clientes clientes){
			return args ->{
			clientes.salvar(new Cliente("Carlos"));
			clientes.salvar(new Cliente("Sabrina"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}


}

