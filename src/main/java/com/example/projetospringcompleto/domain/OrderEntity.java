package com.example.projetospringcompleto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    private Integer id;
    private ClientEntity client;
    private LocalDate dataOrder;
    private Double total;
}
