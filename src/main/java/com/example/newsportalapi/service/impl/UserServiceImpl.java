package com.example.newsportalapi.service.impl;

import com.example.newsportalapi.customException.UserAlreadyExistsException;
import com.example.newsportalapi.dto.UserDto;
import com.example.newsportalapi.dto.UserMapper;
import com.example.newsportalapi.model.User;
import com.example.newsportalapi.repository.UserRepository;
import com.example.newsportalapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserDto registerUser(UserDto userDTO) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByLogin(userDTO.getLogin()));
        existingUser.ifPresent(user -> {
            throw new UserAlreadyExistsException("User already exists with this login");
        });


        User newUser = new User();
        newUser.setLogin(userDTO.getLogin());
        newUser.setFullName(userDTO.getFullName());
        newUser.setAvatarLink(userDTO.getAvatarLink());
        newUser.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(newUser);

        return userMapper.toDto(savedUser);
    }


    @Override
    public String authenticateUser(String login, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByLogin(login));

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                return "Authentication successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }

}