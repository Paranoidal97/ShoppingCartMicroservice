package com.paranoidal97.ShoppingCartMicroservice.mapper;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.ShoppingCartResponseDto;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingCartMapper {
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart);
}
