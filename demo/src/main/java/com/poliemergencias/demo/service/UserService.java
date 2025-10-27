package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.RegistrationDTO;
import com.poliemergencias.demo.model.User;
import com.poliemergencias.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegistrationDTO registrationDTO){
        if (userRepository.findByName(registrationDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Create User entity
        User user = new User();
        user.setName(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword()); // In production, encrypt this!
        user.setRole(registrationDTO.getRole());
        user.setContactoEmergencia(registrationDTO.getContactoEmergencia());

        // Save User first
        return userRepository.save(user);
    }
}
