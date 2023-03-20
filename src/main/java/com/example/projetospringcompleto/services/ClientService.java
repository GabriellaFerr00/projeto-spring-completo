package com.example.projetospringcompleto.services;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity saveclient(ClientEntity client){
        return clientRepository.save(client);
    }
}
