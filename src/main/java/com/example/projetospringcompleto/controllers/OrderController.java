package com.example.projetospringcompleto.controllers;

import com.example.projetospringcompleto.domain.OrderEntity;
import com.example.projetospringcompleto.domain.OrderItemEntity;
import com.example.projetospringcompleto.dto.InformationItemOrderDTO;
import com.example.projetospringcompleto.dto.InformationOrderDTO;
import com.example.projetospringcompleto.dto.OrderDTO;
import com.example.projetospringcompleto.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;


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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InformationOrderDTO getById(@PathVariable("id") Integer id){
        return orderService
                .getFullOrder(id)
                .map(this::convert)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    private InformationOrderDTO convert(OrderEntity order){
       return InformationOrderDTO.builder()
                .cod(order.getId())
                .dataOrder(order.getDataOrder())
                .cpf(order.getClient().getCpf())
                .nameClient(order.getClient().getName())
                .total(order.getTotal())
                .items(this.convertListItem(order.getOrderItem()))
                .build();

    }

    private List<InformationItemOrderDTO> convertListItem(List<OrderItemEntity> itemEntityList){
        if(isEmpty(itemEntityList)){
            return Collections.emptyList();
        }

        return itemEntityList
                .stream()
                .map(item -> InformationItemOrderDTO
                        .builder()
                        .descriptionOrder(item.getProduct().getDescription())
                        .priceUnitary(item.getProduct().getPrice())
                        .amount(item.getAmount())
                        .build()
                ).collect(Collectors.toList());
    }
}
