package com.example.Payment_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Payment_Service.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
