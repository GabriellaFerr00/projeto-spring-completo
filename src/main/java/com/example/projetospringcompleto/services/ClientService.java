package com.example.projetospringcompleto.services;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.exception.MessageCode;
import com.example.projetospringcompleto.exception.MethodNotValidException;
import com.example.projetospringcompleto.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity saveClient(ClientEntity client){
        if(client.getName().isEmpty() && client.getCpf().isEmpty() ){
            throw new MethodNotValidException(MessageCode.INVALID_FIELD);
        }
        return clientRepository.save(client);
    }
}
