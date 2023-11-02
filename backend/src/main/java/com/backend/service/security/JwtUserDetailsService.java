package com.backend.service.security;

import com.backend.controller.request.UserRequest;
import com.backend.entity.User;
import com.backend.repository.RoleRepository;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional.ofNullable(userRepository.findByUsername(username))
                .map(userEntity -> new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getAuthorities()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    public User save(UserRequest user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setRole(roleRepository.findRoleByName("USER"));
        newUser.setEnabled(true);
        return userRepository.save(newUser);
    }

}