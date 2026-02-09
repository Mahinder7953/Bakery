package com.example.Payment_Service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.Payment_Service.models.Payment;
import com.example.Payment_Service.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    
    @Override
    public String processPayment(String orderId, String userId, double amount) {
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setOrderId(orderId);
        payment.setUserId(userId);
        payment.setStatus("DONE");
        payment.setCreatedAt(LocalDateTime.now());
        paymentRepository.save(payment);
        return "Payment processed successfully with ID: " + payment.getId();
    }

}
