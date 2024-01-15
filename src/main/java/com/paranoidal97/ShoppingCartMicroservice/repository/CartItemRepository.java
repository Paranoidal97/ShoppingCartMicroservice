package com.paranoidal97.ShoppingCartMicroservice.repository;

import com.paranoidal97.ShoppingCartMicroservice.model.entity.CartItem;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
