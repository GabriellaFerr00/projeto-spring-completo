package com.example.projetospringcompleto.repositories;

import com.example.projetospringcompleto.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
