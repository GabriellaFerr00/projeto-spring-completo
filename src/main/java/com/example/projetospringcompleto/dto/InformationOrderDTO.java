package com.example.projetospringcompleto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationOrderDTO {
    private Integer cod;
    private String cpf;
    private String nameClient;
    private Double total;
    private LocalDate dataOrder;
    private String status;
    private List<InformationItemOrderDTO> items;
}
