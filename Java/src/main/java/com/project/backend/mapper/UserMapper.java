package com.project.backend.mapper;

import com.project.backend.dto.UserDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.User;

public class UserMapper {
    public static UserDto MapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstName());
        userDto.setLastname(user.getLastName());
        userDto.setSdt(user.getSdt());
        userDto.setAvatar(user.getAvatar());
        userDto.setAccount(user.getAccount());
        return userDto;
    }

    public static User MapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setSdt(userDto.getSdt());
        user.setAvatar(userDto.getAvatar());
        user.setAccount(userDto.getAccount());
        return user;
    }
}
