package com.project.backend.service;

import com.project.backend.dto.UserDto;
import com.project.backend.entity.User;

import java.util.List;

public interface UserService {
    User createUserByOAuth2(User user);
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
