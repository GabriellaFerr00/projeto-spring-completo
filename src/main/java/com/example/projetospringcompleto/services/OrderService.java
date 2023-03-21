package com.example.projetospringcompleto.services;

import com.example.projetospringcompleto.domain.ClientEntity;
import com.example.projetospringcompleto.domain.OrderEntity;
import com.example.projetospringcompleto.domain.OrderItemEntity;
import com.example.projetospringcompleto.domain.ProductEntity;
import com.example.projetospringcompleto.dto.ItemOrderDTO;
import com.example.projetospringcompleto.dto.OrderDTO;
import com.example.projetospringcompleto.exception.BussinessRuleException;
import com.example.projetospringcompleto.repositories.ClientRepository;
import com.example.projetospringcompleto.repositories.OrderItemRepository;
import com.example.projetospringcompleto.repositories.OrderRepository;
import com.example.projetospringcompleto.repositories.ProductRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public OrderEntity saveOrder(OrderDTO dto){
        Integer idClient = dto.getIdClient();
        ClientEntity client = clientRepository.findById(idClient)
                .orElseThrow(() -> new BussinessRuleException("Invalid client code"));

        OrderEntity order = new OrderEntity();
        order.setTotal(dto.getTotal());
        order.setDataOrder(LocalDate.now());
        order.setClient(client);

       List<OrderItemEntity> orderItemEntities =  this.convertItems(order, dto.getItems());

       orderRepository.save(order);
       orderItemRepository.saveAll(orderItemEntities);

       order.setOrderItem(orderItemEntities);

       return order;

    }

    private List<OrderItemEntity> convertItems(OrderEntity order, List<ItemOrderDTO> dtoItems) {
        if(dtoItems.isEmpty()) {
            throw new BussinessRuleException("It is not possible to place an order without an item");
        }

        return dtoItems
                .stream()
                .map(dto -> {
                    Integer idProduct = dto.getIdProduct();
                    ProductEntity product = productRepository.findById(idProduct)
                            .orElseThrow(() -> new BussinessRuleException("Invalid client code" + idProduct));

                    OrderItemEntity orderItem = new OrderItemEntity();
                    orderItem.setAmount(dto.getAmount());
                    orderItem.setOrder(order);
                    orderItem.setProduct(product);

                    return  orderItem;
                }).collect(Collectors.toList());


    }

}
