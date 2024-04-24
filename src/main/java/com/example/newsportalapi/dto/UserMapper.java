package com.example.newsportalapi.dto;

import com.example.newsportalapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "login", source = "user.login")
    @Mapping(target = "fullName", source = "user.fullName")
    @Mapping(target = "avatarLink", source = "user.avatarLink")
    UserDto toDto(User user);

    @Mapping(target = "login", source = "userDto.login")
    @Mapping(target = "fullName", source = "userDto.fullName")
    @Mapping(target = "avatarLink", source = "userDto.avatarLink")
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto userDto);
}
