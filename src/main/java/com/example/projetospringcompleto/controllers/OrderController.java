package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.OrderEntity;
import com.example.projetospringcompleto.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity createOrder(@RequestBody OrderEntity order){
        return orderRepository.save(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderEntity> getAllOrder(OrderEntity entityFilter) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<OrderEntity> example = Example.of(entityFilter, exampleMatcher);

        return orderRepository.findAll(example);

    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderEntity getOrderById(@PathVariable("id") Integer id){
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id){
        orderRepository.findById(id)
                .map(order ->{
                    orderRepository.deleteById(order.getId());
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrderById(@PathVariable("id") Integer id,
                                @RequestBody OrderEntity orderEntity){
        orderRepository
                .findById(id)
                .map(orderExisting -> {
                    orderEntity.setId(orderExisting.getId());
                    orderRepository.save(orderEntity);
                    return orderEntity;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
}
