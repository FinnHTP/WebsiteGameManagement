package com.project.backend.service.impl;

import com.project.backend.dto.UserDto;
import com.project.backend.entity.User;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.UserMapper;
import com.project.backend.repository.UserRepository;
import com.project.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.MapToUser(userDto);
        User newUser = userRepository.save(user);
        return UserMapper.MapToUserDto(newUser);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.MapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User can't be found with given id " + id));
        return UserMapper.MapToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User can't be found with given id " + id));
        // Update user's info except the account id
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setSdt(userDto.getSdt());
        User updatedUser = userRepository.save(user);
        return UserMapper.MapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User can't be found with given id " + id));
        userRepository.deleteById(id);
    }
}
