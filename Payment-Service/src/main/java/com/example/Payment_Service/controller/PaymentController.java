package com.example.Payment_Service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Payment_Service.service.PaymentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@RestController
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping("/processPayment/{userId}/{orderId}/{amount}")
    public String processPayment(@PathVariable String userId,@PathVariable String orderId,@PathVariable String amount) {
        return paymentService.processPayment(orderId, userId, Double.parseDouble(amount));
    }
    
}
