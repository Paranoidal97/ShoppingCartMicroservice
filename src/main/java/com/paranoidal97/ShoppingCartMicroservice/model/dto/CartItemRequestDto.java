package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class CartItemRequestDto {
    private String id;
    private String name;
    private BigDecimal price;
    private String processor;
    private String type;
    private int ram;
    private String color;
    private int batteryCapacity;
    private String accesories;
}
