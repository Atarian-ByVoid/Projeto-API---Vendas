package com.br.globalfinanceiro.vendas.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.br.globalfinanceiro.vendas.domain.Cliente;

@Repository
public class Clientes {

    private static String INSERT="Insert into cliente (nome) values (?)";
    private static String SELECT_ALL="SELECT * FROM CLIENTE";
    private static String UPDATE="update cliente set nome=? where id=?";
    private static String DELETE="delete from cliente where nome id=?";
 



    @Autowired
    private JdbcTemplate jdbcTemplate;
    //salva um cliente
    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()} );
        return cliente;
        
    }
    //atualiza um cliente
    public Cliente atualizar (Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente){
        deletar(cliente.getId());
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});

    }

    public List<Clientes> buscarPorNome(String nome){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper, null, null)
    }


    //lista todos os clientes
    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>(){
            @Override
            public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id,nome);
            }
                
        });
    }


    
    
}
