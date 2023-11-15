package com.csl.b4.ims.user.controller;

import com.csl.b4.ims.user.model.User;
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
    public ResponseEntity<List<User>> getUsers(){
        List<User> dtos = userService.findAllUsers();
        return !dtos.isEmpty() ? ResponseEntity.ok(dtos) : ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User dto){
        return ResponseEntity.ok(userService.saveUser(dto));
    }

}
