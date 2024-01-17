package com.paranoidal97.ShoppingCartMicroservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baseId;
    private String variantId;
    private String name;
    private BigDecimal price;
    private String processor;
    private int ram;
    private String color;
    private int batteryCapacity;
    private String accesories;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnore
    private ShoppingCart shoppingCart;
}
