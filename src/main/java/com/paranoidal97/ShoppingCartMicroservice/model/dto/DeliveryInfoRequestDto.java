package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import com.paranoidal97.ShoppingCartMicroservice.model.entity.ShoppingCart;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeliveryInfoRequestDto {
    private String name;
    private String surname;
    private String adress;
    private String payment;
    private String delivery;
}
