package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryInfoRequestDto {
    private final String name;
    private final String surname;
    private final String address;
    private final String payment;
    private final String delivery;
}
