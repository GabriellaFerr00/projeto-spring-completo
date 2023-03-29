package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientEntity saveClient(@RequestBody @Valid ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientEntity getClientById(@PathVariable("id") Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @GetMapping
    public List<ClientEntity> findClient(ClientEntity filter) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<ClientEntity> example = Example.of(filter, exampleMatcher);

        return clientRepository.findAll(example);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("id") Integer id) {
        clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return client;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClient(@PathVariable("id") Integer id,
                             @RequestBody ClientEntity client) {

        clientRepository
                .findById(id)
                .map(clientExisting -> {
                    client.setId(clientExisting.getId());
                    clientRepository.save(client);
                    return clientExisting;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }
}
