package com.example.newsportalapi.service;

import com.example.newsportalapi.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDTO);
    String authenticateUser(String login, String password);
}
