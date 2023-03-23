package com.example.projetospringcompleto.repositories;

import com.example.projetospringcompleto.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("select o from OrderEntity o left join fetch o.orderItem where o.id = :id")
    Optional<OrderEntity> findByIdFetchOrderItem(@Param("id") Integer id);

}
