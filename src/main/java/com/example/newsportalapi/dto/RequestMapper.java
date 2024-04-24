package com.example.newsportalapi.dto;

import com.example.newsportalapi.model.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(target = "product", source = "product")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "deliveryAddress", source = "deliveryAddress")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    RequestDto toDto(Request request);

    @Mapping(target = "product", source = "product")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "deliveryAddress", source = "deliveryAddress")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    Request toEntity(RequestDto requestDto);
}

