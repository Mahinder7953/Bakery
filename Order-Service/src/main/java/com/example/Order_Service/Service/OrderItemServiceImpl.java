package com.example.Order_Service.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.Order_Service.Client.BakeryInventoryClient;
import com.example.Order_Service.Model.Orders;
import com.example.Order_Service.Model.OrderItem;
import com.example.Order_Service.Repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private OrderRepository orderRepository;
    private BakeryInventoryClient bakeryInventoryClient;

    @Override
    public void placeOrder(int itemId) {
        OrderItem item = bakeryInventoryClient.getItemById(itemId);
        Orders order = new Orders();
        order.setName(item.getName());
        order.setPrice(item.getPrice());
        order.setOrderDate(LocalDateTime.now());        
        orderRepository.save(order);
    }

}
