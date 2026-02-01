package com.example.Order_Service.Model;

import lombok.Data;

@Data
public class OrderItem {
    private int id;
    private String name;
    private Double price;
}