package com.example.Delivery_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Delivery_Service.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
