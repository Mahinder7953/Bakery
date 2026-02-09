package com.example.Delivery_Service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.Delivery_Service.model.Delivery;
import com.example.Delivery_Service.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {
    private DeliveryRepository deliveryRepository;

    @Override
    public String createDelivery(Delivery delivery) {
        delivery.setCreatedAt(LocalDateTime.now());
        delivery.setStatus("Scheduled");
        delivery.setUpdatedAt(LocalDateTime.now());
        deliveryRepository.save(delivery);
        return "Delivery created successfully";
    }

    @Override
    public String trackStatus(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery != null) {
            return "Delivery Status: " + delivery.getStatus();
        } else {
            return "Delivery not found";
        }
    }
}
