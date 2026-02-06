package com.example.Cart_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Cart_Service.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    void deleteByCartIdAndProductId(Long cartId, Long productId);

    CartItem findByCartIdAndProductId(Long cartId, Long productId);

    @Query("SELECT SUM(c.totalPrice) FROM CartItem c WHERE c.cartId = :cartId")
    Double getCartTotal(@Param("cartId") Long cartId);
}

