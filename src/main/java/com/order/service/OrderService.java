package com.order.service;

import com.order.model.Order;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrdersList() {
        List<Order> itemList = orderRepository.findAll().stream().collect(Collectors.toList());
        return itemList;
    }


    public void postAnOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }
}
