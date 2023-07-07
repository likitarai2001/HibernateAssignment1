package com.example.socialmediaapp.service.Impl;

import com.example.socialmediaapp.converters.UserToUserProfileDtoConverter;
import com.example.socialmediaapp.dto.UserProfileDto;
import com.example.socialmediaapp.entities.User;
import com.example.socialmediaapp.repository.UserRepository;
import com.example.socialmediaapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserProfileDtoConverter userToUserProfileDtoConverter;

    @Override
    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        log.info("User saved successfully");
        return savedUser;
    }

    @Override
    public List<UserProfileDto> getAllUsers() {
        List<UserProfileDto> userProfileDtoList = userRepository.findAll().stream().map(userToUserProfileDtoConverter::convert).toList();
        log.info("User loaded successfully");
        return userProfileDtoList;
    }
}
