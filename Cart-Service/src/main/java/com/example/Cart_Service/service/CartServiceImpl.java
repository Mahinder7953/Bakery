package com.example.Cart_Service.service;

import org.springframework.stereotype.Service;

import com.example.Cart_Service.repository.CartItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private CartItemRepository cartItemRepository;

    @Override
    public Double getCartTotal(Long cartId) {
        return cartItemRepository.getCartTotal(cartId);
    }
}
