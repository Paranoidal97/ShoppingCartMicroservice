package com.paranoidal97.ShoppingCartMicroservice.mapper;

import com.paranoidal97.ShoppingCartMicroservice.model.dto.DeliveryInfoRequestDto;
import com.paranoidal97.ShoppingCartMicroservice.model.entity.DeliveryInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DeliveryInfoMapper {
    DeliveryInfo toEntity(DeliveryInfoRequestDto deliveryInfoRequestDto);
}
