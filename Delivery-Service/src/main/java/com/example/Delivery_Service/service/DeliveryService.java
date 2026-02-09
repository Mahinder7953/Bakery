package com.example.Delivery_Service.service;

import com.example.Delivery_Service.model.Delivery;

public interface DeliveryService {
    String createDelivery(Delivery delivery);

    String trackStatus(Long deliveryId);
}
