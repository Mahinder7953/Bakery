package com.example.Payment_Service.service;

public interface PaymentService {
    String processPayment(String orderId, String userId, double amount);

}
