package com.example.projetospringcompleto.repositories;

import com.example.projetospringcompleto.domain.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
