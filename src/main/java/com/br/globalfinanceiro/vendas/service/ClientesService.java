package com.br.globalfinanceiro.vendas.service;

import org.springframework.stereotype.Service;

import com.br.globalfinanceiro.vendas.model.Cliente;
import com.br.globalfinanceiro.vendas.repository.ClientesRepository;

@Service
public class ClientesService {

    private ClientesRepository repository;

    public ClientesService(ClientesRepository repository){
        this.repository = repository;


    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);

    }
    
    public void validarCliente(Cliente client){

    }
}
