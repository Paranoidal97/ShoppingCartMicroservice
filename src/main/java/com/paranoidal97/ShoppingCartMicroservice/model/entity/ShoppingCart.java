package com.paranoidal97.ShoppingCartMicroservice.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table
@ToString
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
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    DeliveryInfo deliveryInfo;
}
