package com.example.Cart_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Cart_Service.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
    