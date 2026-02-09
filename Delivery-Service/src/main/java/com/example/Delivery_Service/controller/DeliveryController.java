package com.example.Delivery_Service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery_Service.model.Delivery;
import com.example.Delivery_Service.service.DeliveryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@RestController
public class DeliveryController {
    private DeliveryService deliveryService;

    @PostMapping("/createDelivery")
    public String createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery);
    }
    
    @GetMapping("/trackStatus/{id}")
    public String trackStatus(@PathVariable Long id) {
        return deliveryService.trackStatus(id);
    }
    
}
