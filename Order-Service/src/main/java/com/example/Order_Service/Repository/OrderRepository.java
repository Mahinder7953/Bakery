package com.example.Order_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Order_Service.Model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
