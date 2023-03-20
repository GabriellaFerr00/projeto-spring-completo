package com.example.projetospringcompleto.repositories;

import com.example.projetospringcompleto.domain.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
