package com.example.projetospringcompleto.dto;

import com.example.projetospringcompleto.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull(message = "Enter customer code")
    private Integer idClient;
    @NotNull(message = "Order total field is required")
    private Double total;
    @NotEmptyList(message = "Order cannot be placed without items.")
    private List<ItemOrderDTO> items;
}
