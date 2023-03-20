package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.ok(clients.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody ClientEntity clientEntity){
        ClientEntity client = clientRepository.save(clientEntity);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id){
        Optional<ClientEntity> clients = clientRepository.findById(id);
        if(clients.isPresent()){
            clientRepository.delete(clients.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateClient(@PathVariable Integer id,
                                       @RequestBody ClientEntity client){

        return clientRepository
                .findById(id)
                .map(clientExisting -> {
                    client.setId(clientExisting.getId());
                    clientRepository.save(client);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
