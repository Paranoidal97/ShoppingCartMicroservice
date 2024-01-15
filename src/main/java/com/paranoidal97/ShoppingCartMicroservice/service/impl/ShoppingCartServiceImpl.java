package com.paranoidal97.ShoppingCartMicroservice.service.impl;

import com.paranoidal97.ShoppingCartMicroservice.exception.DataNotFoundException;
import com.paranoidal97.ShoppingCartMicroservice.exception.OrderAlreadyPaidException;
import com.paranoidal97.ShoppingCartMicroservice.mapper.CartItemMapper;
import com.paranoidal97.ShoppingCartMicroservice.mapper.DeliveryInfoMapper;
import com.paranoidal97.ShoppingCartMicroservice.mapper.ShoppingCartMapper;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.CartItemRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.DeliveryInfoRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.dto.ShoppingCartResponseDto;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.CartItem;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.DeliveryInfo;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.ShoppingCart;
import com.paranoidal97.ShoppingCartMicroservice.model.enums.CartStatus;
import com.paranoidal97.ShoppingCartMicroservice.repository.CartItemRepository;
import com.paranoidal97.ShoppingCartMicroservice.repository.ShoppingCartRepository;
import com.paranoidal97.ShoppingCartMicroservice.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final CartItemMapper cartItemMapper;
    private final DeliveryInfoMapper deliveryInfoMapper;

    @Scheduled(cron = "0 0 0 * * *")
    public void cleanupOutdatedShoppingCarts() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusDays(1);
        shoppingCartRepository.deleteOutdatedShoppingCarts(cutoffTime);
    }

    @Override
    public ShoppingCartResponseDto createShoppingCart() {
        ShoppingCart newShoppingCart = new ShoppingCart();
        LocalDateTime now = LocalDateTime.now();
        newShoppingCart.setLastModified(now);
        newShoppingCart.setStatus(CartStatus.UNPAID);

        System.out.println(newShoppingCart.toString());

        return shoppingCartMapper.toDto(
                shoppingCartRepository.save(newShoppingCart));
    }

    @Override
    public ShoppingCartResponseDto addCartItem(Long id, CartItemRequestDto cartItemRequestDto) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Cart")
                );
        if(shoppingCart.getStatus().equals(CartStatus.PAID)){
            throw new OrderAlreadyPaidException("You cant add new product to paid Order");
        }
        CartItem cartEntity = cartItemMapper.toEntity(cartItemRequestDto);
        cartEntity.setShoppingCart(shoppingCart);
        LocalDateTime now = LocalDateTime.now();
        shoppingCart.getProducts().add(cartEntity);
        shoppingCart.setLastModified(now);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDto getShoppingCart(Long id) {
        ShoppingCart cartById = shoppingCartRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Cart")
                );
        return shoppingCartMapper.toDto(cartById);
    }

    @Override
    public ShoppingCartResponseDto editStatus(Long id, String status) {
        ShoppingCart cartById = shoppingCartRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Cart")
                );
        CartStatus cartStatus = CartStatus.fromString(status);
        cartById.setStatus(cartStatus);
        shoppingCartRepository.save(cartById);
        return shoppingCartMapper.toDto(cartById);
    }

    public ShoppingCartResponseDto deleteCartItem(Long cartId, Long itemId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Cart")
                );

        return shoppingCartMapper.toDto(shoppingCart);
    }

    public ShoppingCartResponseDto addDeliveryInfo(Long id, DeliveryInfoRequestDto deliveryInfo) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Cart")
                );
        if(shoppingCart.getStatus().equals(CartStatus.PAID)){
            throw new OrderAlreadyPaidException("You cant delivery info to paid Order");
        }
        DeliveryInfo deliveryInfoEntity = deliveryInfoMapper.toEntity(deliveryInfo);
        deliveryInfoEntity.setCart(shoppingCart);
        shoppingCart.setDeliveryInfo(deliveryInfoEntity);
        LocalDateTime now = LocalDateTime.now();
        shoppingCart.setLastModified(now);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toDto(shoppingCart);
    }
}
