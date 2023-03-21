package com.example.projetospringcompleto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderDTO {
    private Integer idProduct;
    private Integer amount;

}
