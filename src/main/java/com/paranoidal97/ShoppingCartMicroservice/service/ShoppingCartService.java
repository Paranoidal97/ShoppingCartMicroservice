package com.paranoidal97.ShoppingCartMicroservice.service;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.CartItemRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.DeliveryInfoRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartService {
    ShoppingCartResponseDto createShoppingCart();

    ShoppingCartResponseDto addCartItem(Long id, CartItemRequestDto cartItemRequestDto);

    ShoppingCartResponseDto getShoppingCart(Long id);

    public ShoppingCartResponseDto editStatus(Long id, String status);

    public ShoppingCartResponseDto deleteCartItem(Long cartId, Long itemId);

    public ShoppingCartResponseDto addDeliveryInfo(Long id, DeliveryInfoRequestDto deliveryInfo);
}
