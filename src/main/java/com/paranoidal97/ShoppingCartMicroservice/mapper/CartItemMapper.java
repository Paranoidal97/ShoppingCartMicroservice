package com.paranoidal97.ShoppingCartMicroservice.mapper;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.CartItemRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CartItemMapper {

    @Mapping(source = "id", target = "baseId")
    @Mapping(ignore = true, target = "id")
    CartItem toEntity(CartItemRequestDto cartItemRequestDto);

}
