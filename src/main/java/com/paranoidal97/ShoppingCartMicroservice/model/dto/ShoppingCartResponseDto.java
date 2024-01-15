package com.paranoidal97.ShoppingCartMicroservice.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.CartItem;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.DeliveryInfo;
import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ShoppingCartResponseDto {
    private Long id;
    private List<CartItem> products;
    private CartStatus status;
    private DeliveryInfo deliveryInfo;
    private LocalDateTime lastModified;
}
