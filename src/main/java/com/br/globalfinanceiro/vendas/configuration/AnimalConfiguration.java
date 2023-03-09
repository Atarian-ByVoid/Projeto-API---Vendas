package com.br.globalfinanceiro.vendas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.globalfinanceiro.vendas.Annotations.Animal;

@Configuration
public class AnimalConfiguration {

    @Bean(name="cahorro")
    public Animal cachorro(){
        return new Animal(){
            @Override
            public void fazerBarulho(){
                System.out.println("AuAu");

            }

            };
        }

        @Bean(name="gato")
    public Animal gato(){
        return new Animal(){
            @Override
            public void fazerBarulho(){
                System.out.println("Miau");

            }

            };
        }
}
