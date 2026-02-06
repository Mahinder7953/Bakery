package com.example.Cart_Service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Cart_Service.service.CartItemService;
import com.example.Cart_Service.service.CartService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;



@AllArgsConstructor
@RestController
public class CartController {
    private CartService cartService;
    private CartItemService cartItemService;

    @PostMapping("/addCartItem/{cartId}")
    public void addCartItem(@PathVariable Long cartId,@RequestParam Long productId,@RequestParam Integer quantity) {
        cartItemService.addCartItem(cartId, productId, quantity);
    }
    
    @DeleteMapping("/removeCartItem/{cartId}")
    public void removeCartItem(@PathVariable Long cartId,@RequestParam Long productId) {
        cartItemService.removeCartItem(cartId, productId);
    }
    @PutMapping("/updateCartItemQuantity/{cartId}")
    public void updateCartItemQuantity(@PathVariable Long cartId,@RequestParam Long productId,@RequestParam Integer quantity) {
        cartItemService.updateCartItemQuantity(cartId, productId, quantity);
    }
    @GetMapping("/cart/total/{cartId}")
    public double getCartTotal(@PathVariable Long cartId) {
        return cartService.getCartTotal(cartId);
    }
    
}
