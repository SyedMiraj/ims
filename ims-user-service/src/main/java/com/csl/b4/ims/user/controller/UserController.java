package com.csl.b4.ims.user.controller;

import com.csl.b4.ims.user.model.AuthRequest;
import com.csl.b4.ims.user.model.UserDto;
import com.csl.b4.ims.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.saveUser(dto));
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

    @PostMapping("/auth/token")
    public @ResponseBody String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/auth/validate")
    public @ResponseBody void validateToken(@RequestParam("token") String token) {
        Boolean tokenValidity = userService.validateToken(token);
        if(!tokenValidity){
            throw new RuntimeException("invalid token");
        }
    }
}
