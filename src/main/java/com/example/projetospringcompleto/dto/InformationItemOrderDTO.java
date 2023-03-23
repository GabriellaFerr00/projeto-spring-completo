package com.example.projetospringcompleto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationItemOrderDTO {
    private String descriptionOrder;
    private Double priceUnitary;
    private Integer amount;
}
