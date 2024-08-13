package com.project.backend.service.impl;

import com.project.backend.dto.UserDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.User;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.UserMapper;
import com.project.backend.repository.UserRepository;
import com.project.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User createUserByOAuth2(User user) {
        userRepository.save(user);
        return user;
    }

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
    
    
    @Override
    public void uploadAvatar (Long id, MultipartFile file) throws IOException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
        {
            User user = optionalUser.get();
            user.setAvatar(file.getBytes());
            userRepository.save(user);
        } else
        {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public byte[] getAvatar (Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent() && optionalUser.get().getAvatar() != null)
        {
            return optionalUser.get().getAvatar();
        } else
        {
            throw new RuntimeException("Avatar not found");
        }
    }

    @Override
    public List<User> getListUserById(List<Integer> myList) {
        List<User> users = new ArrayList<>();
        System.out.println("Input ID list: " + myList);
        for (Integer number : myList) {
            User user = userRepository.getUserById(number);
            if (user != null) {
                users.add(user);
                System.out.println("User added: " + user.getId());
            } else {
                System.out.println("No user found with ID: " + number);
            }
        }
        System.out.println("Total users added: " + users.size());
        return users; // Or simply return users;
    }
}
