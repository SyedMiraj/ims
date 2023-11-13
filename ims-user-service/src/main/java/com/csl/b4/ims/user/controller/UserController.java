package com.csl.b4.ims.user.controller;

import com.csl.b4.ims.user.model.UserDto;
import com.csl.b4.ims.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> dtos = userService.findAllUsers();
        return !dtos.isEmpty() ? ResponseEntity.ok(dtos) : ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id){
        UserDto user = userService.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.saveUser(dto));
    }

}
