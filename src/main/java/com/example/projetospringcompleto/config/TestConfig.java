package com.example.projetospringcompleto.config;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.domain.ProductEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import com.example.projetospringcompleto.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        ClientEntity client = new ClientEntity(null, "Gabi", "123456789");
        clientRepository.save(client);

        ProductEntity product = new ProductEntity(null, "Mouse", 150.0);
        productRepository.save(product);
    }
}
