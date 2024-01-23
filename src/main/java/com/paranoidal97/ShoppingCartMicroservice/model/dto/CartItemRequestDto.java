package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartItemRequestDto {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final String processor;
    private final String type;
    private final int ram;
    private final String color;
    private final int batteryCapacity;
    private final String accesories;
}
