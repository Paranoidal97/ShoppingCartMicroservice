package com.paranoidal97.ShoppingCartMicroservice.model.entity;

import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CartStatus status;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "shoppingCart",
            cascade = CascadeType.ALL)
    List<CartItem> products;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastModified;
    @OneToOne(mappedBy = "cart" ,cascade = CascadeType.ALL)
    DeliveryInfo deliveryInfo;
}
