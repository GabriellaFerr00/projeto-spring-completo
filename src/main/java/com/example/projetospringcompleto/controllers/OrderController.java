package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.OrderEntity;
import com.example.projetospringcompleto.dto.OrderDTO;
import com.example.projetospringcompleto.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createOrder(@RequestBody OrderDTO dto){
        OrderEntity order = orderService.saveOrder(dto);
        return order.getId();
    }

}
