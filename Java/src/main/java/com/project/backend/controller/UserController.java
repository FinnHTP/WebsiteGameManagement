package com.project.backend.controller;

import com.project.backend.dto.UserDto;
import com.project.backend.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        UserDto newUserDto = userService.updateUser(id, userDto);
        return new ResponseEntity<>(newUserDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping ("/{id}/avatar")
    public ResponseEntity<String> uploadAvatar (@PathVariable Long id,  @RequestParam ("avatar") MultipartFile file) {
        try
        {
            userService.uploadAvatar(id , file);
            return ResponseEntity.ok("Avatar uploaded successfully");
        } catch (IOException e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload avatar");
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping ("/{id}/avatar")
    public ResponseEntity<byte[]> getAvatar (@PathVariable Long id) {
        try
        {
            byte[] avatar = userService.getAvatar(id);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG) // Adjust based on the image type stored
                    .body(avatar);
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
