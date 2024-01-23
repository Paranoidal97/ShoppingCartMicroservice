package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import com.paranoidal97.ShoppingCartMicroservice.model.entity.CartItem;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.DeliveryInfo;
import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ShoppingCartResponseDto {
    private final Long id;
    private final List<CartItem> products;
    private final CartStatus status;
    private final DeliveryInfo deliveryInfo;
    private final LocalDateTime lastModified;
}
