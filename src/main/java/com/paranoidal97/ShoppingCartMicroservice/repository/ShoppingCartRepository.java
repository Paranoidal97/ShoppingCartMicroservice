package com.paranoidal97.ShoppingCartMicroservice.repository;

import com.paranoidal97.ShoppingCartMicroservice.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query("SELECT s FROM ShoppingCart s WHERE s.lastModified < :cutoffTime")
    List<ShoppingCart> findOutdatedShoppingCarts(LocalDateTime cutoffTime);

    @Query("DELETE FROM ShoppingCart s WHERE s.lastModified < :cutoffTime")
    void deleteOutdatedShoppingCarts(LocalDateTime cutoffTime);
}
