package com.example.projetospringcompleto.config;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        ClientEntity client =  new ClientEntity(null, "Gabi");
        clientRepository.save(client);
    }
}
