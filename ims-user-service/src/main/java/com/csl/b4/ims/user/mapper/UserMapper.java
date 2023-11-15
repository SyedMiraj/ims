package com.csl.b4.ims.user.mapper;

import com.csl.b4.ims.user.entity.UserEntity;
import com.csl.b4.ims.user.model.User;
import com.csl.b4.ims.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity toEntity(User dto){
        UserEntity entity = userRepository.findById(dto.getId())
                .orElse(new UserEntity());
        entity.setPhone(dto.getPhone());
        entity.setFullName(dto.getFullName());
        entity.setUsername(dto.getUsername());
        entity.setRole(dto.getRole());
        return entity;
    }

    public User toDto(UserEntity entity){
        User dto =  new User();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setFullName(entity.getFullName());
        dto.setUsername(entity.getUsername());
        dto.setRole(entity.getRole());
        return dto;
    }
}
