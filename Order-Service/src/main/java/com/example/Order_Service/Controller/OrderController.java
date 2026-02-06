package com.example.Order_Service.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Order_Service.Service.OrderItemService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@RestController
public class OrderController {
    private OrderItemService orderItemService;

    @PostMapping("/order/{id}")
    public void placeOrder(@PathVariable int id) {
        orderItemService.placeOrder(id);
    }
    
}
