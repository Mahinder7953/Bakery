package com.example.Order_Service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Order_Service.Model.OrderItem;

@FeignClient(name = "Catalog-Service", url = "${Catalog-service.url}")
public interface BakeryInventoryClient {
    @GetMapping("/{id}")
    OrderItem getItemById(@PathVariable("id")int id);
}
