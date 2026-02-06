package com.example.Cart_Service.service;

import org.springframework.stereotype.Service;

import com.example.Cart_Service.model.CartItem;
import com.example.Cart_Service.repository.CartItemRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    @Override
    public void addCartItem(Long cartId, Long productId, Integer quantity) {
        CartItem cartItem = CartItem.builder()
                .cartId(cartId)
                .productId(productId)
                .quantity(quantity)
                .build();
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long cartId, Long productId) {
        cartItemRepository.deleteByCartIdAndProductId(cartId, productId);
    }

    @Override
    public void updateCartItemQuantity(Long cartId, Long productId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cartId, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

}
