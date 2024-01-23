package com.paranoidal97.ShoppingCartMicroservice.controller;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.CartItemRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.DeliveryInfoRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.ShoppingCartResponseDto;
import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import com.paranoidal97.ShoppingCartMicroservice.service.impl.ShoppingCartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartServiceImpl service;

    @GetMapping("/{id}")
    public ShoppingCartResponseDto getShoppingCart(@PathVariable Long id) {
        return service.getShoppingCart(id);
    }

    @PostMapping
    public ShoppingCartResponseDto createShoppingCart() {
        return service.createShoppingCart();
    }

    @PostMapping("/{id}/cart-items")
    public ShoppingCartResponseDto addCartItem(@PathVariable Long id, @RequestBody CartItemRequestDto cartItemRequestDto) {
        return service.addCartItem(id, cartItemRequestDto);
    }

    @DeleteMapping("/{cartId}/cart-item/{itemId}")
    public ShoppingCartResponseDto deleteCartItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        return service.deleteCartItem(cartId, itemId);
    }

    @PostMapping("/{id}/add-delivery-info")
    public ShoppingCartResponseDto addDeliveryInfo(@PathVariable Long id, @RequestBody DeliveryInfoRequestDto deliveryInfo) {
        return service.addDeliveryInfo(id, deliveryInfo);
    }

    @PatchMapping("/{id}/status")
    public ShoppingCartResponseDto changeStatus(@PathVariable Long id, @RequestParam CartStatus cartStatus) {
        return service.editStatus(id, cartStatus);
    }


}
