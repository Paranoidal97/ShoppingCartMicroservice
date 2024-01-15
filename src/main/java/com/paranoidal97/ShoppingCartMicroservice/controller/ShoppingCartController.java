package com.paranoidal97.ShoppingCartMicroservice.controller;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.CartItemRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.DeliveryInfoRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.ShoppingCartResponseDto;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.DeliveryInfo;
import com.paranoidal97.ShoppingCartMicroservice.service.impl.ShoppingCartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartServiceImpl service;

    @PostMapping
    public ShoppingCartResponseDto createShoppingCart() {
        return service.createShoppingCart();
    }

    @PatchMapping("/addCartItem/{id}")
    public ShoppingCartResponseDto addCartItem(@PathVariable Long id, @RequestBody CartItemRequestDto cartItemRequestDto) {
        return service.addCartItem(id, cartItemRequestDto);
    }

    @PatchMapping("/deleteCartItem/{cartId}/{itemId}")
    public ShoppingCartResponseDto deleteCartItem(@PathVariable Long cartId,@PathVariable Long itemId) {
        return service.deleteCartItem(cartId,itemId);
    }

    @PatchMapping("/addDeliveryInfo/{id}")
    public ShoppingCartResponseDto addDeliveryInfo(@PathVariable Long id, @RequestBody DeliveryInfoRequestDto deliveryInfo) {
        return service.addDeliveryInfo(id, deliveryInfo);
    }

    @PatchMapping("/{id}/{status}")
    public ShoppingCartResponseDto addCartItem(@PathVariable Long id, @PathVariable String status ) {
        return service.editStatus(id, status);
    }

    @GetMapping("/{id}")
    public ShoppingCartResponseDto getShoppingCart(@PathVariable Long id) {
        return service.getShoppingCart(id);
    }
}
