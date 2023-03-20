package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable Integer id){
        Optional<ClientEntity> clients = clientRepository.findById(id);
        if(clients.isPresent()){
            return  ResponseEntity.ok(clients.get());
        }
        return ResponseEntity.notFound().build();
    }

}
