package com.example.projetospringcompleto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity {
    private Integer id;
    private OrderEntity order;
    private ProductEntity product;
    private Integer amount;
}
