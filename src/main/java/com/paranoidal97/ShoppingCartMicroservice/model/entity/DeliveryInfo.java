package com.paranoidal97.ShoppingCartMicroservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@ToString
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String adress;
    private String payment;
    private String delivery;
    @OneToOne
    @MapsId
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnore
    private ShoppingCart cart;
}
