package com.csl.b4.ims.user.service;

import com.csl.b4.ims.user.entity.UserEntity;
import com.csl.b4.ims.user.mapper.UserMapper;
import com.csl.b4.ims.user.model.User;
import com.csl.b4.ims.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User dto){
        log.info("Saving user");
        UserEntity entity = userMapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        UserEntity persistedEntity = userRepository.save(entity);
        log.info("User saved for user " + persistedEntity.getFullName() + " with id " + persistedEntity.getId());
        return userMapper.toDto(persistedEntity);
    }

    public List<User> findAllUsers() {
        log.info("Fetching all users");
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public User findUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElse(null);
    }
}
