package com.order.controller;

import com.order.model.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/order")
public class OrderServiceController {


    @Autowired
    OrderService orderService;


    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> itemList = orderService.getAllOrdersList();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<String> postAnOrder(@RequestBody Order newOrder) {
        if (newOrder.getProduct_id() != 0 || newOrder.getProduct().isEmpty()) {
            orderService.postAnOrder(newOrder);
        } else {
          return new ResponseEntity<String>("Failed to save new Order Entry",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Successfully Saved the New Order",HttpStatus.OK);
    }
}
