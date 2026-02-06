package com.example.Cart_Service.service;

public interface CartItemService {
    void addCartItem(Long cartId, Long productId, Integer quantity);

    void removeCartItem(Long cartId, Long productId);

    void updateCartItemQuantity(Long cartId, Long productId, Integer quantity);
}
