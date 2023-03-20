package com.example.projetospringcompleto.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_tb")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataOrder;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItem;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", dataOrder=" + dataOrder +
                ", total=" + total +
                ", client=" + client +
                ", orderItem=" + orderItem +
                '}';
    }
}
