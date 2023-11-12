package com.csl.b4.ims.user.service;

import com.csl.b4.ims.user.entity.UserEntity;
import com.csl.b4.ims.user.model.ImsUserDetails;
import com.csl.b4.ims.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(username);
        return optionalUserEntity
                .map(user -> new ImsUserDetails(optionalUserEntity.get().getUsername(), optionalUserEntity.get().getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
    }
}
