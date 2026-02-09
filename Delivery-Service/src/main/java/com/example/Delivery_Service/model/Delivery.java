package com.example.Delivery_Service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long userId;
    private String status;
    private LocalDateTime scheduledDate;
    private String deliveredAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
