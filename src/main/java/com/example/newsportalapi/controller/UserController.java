package com.example.newsportalapi.controller;

import com.example.newsportalapi.dto.UserDto;
import com.example.newsportalapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        userDto.setLogin(userDto.getLogin().trim().toLowerCase());
        userDto.setFullName(userDto.getFullName().trim());
        userDto.setAvatarLink(userDto.getAvatarLink().trim());

        return ResponseEntity.ok(userService.registerUser(userDto));
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        String response = userService.authenticateUser(userDto.getLogin().trim().toLowerCase(), userDto.getPassword());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
