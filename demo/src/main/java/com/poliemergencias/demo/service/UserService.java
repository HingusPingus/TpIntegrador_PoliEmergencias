package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.LoginDTO;
import com.poliemergencias.demo.dto.RegistrationDTO;
import com.poliemergencias.demo.model.User;
import com.poliemergencias.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Transactional
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

    @Transactional
    public int getEmergencia(Long idUsuario){
        Optional<User> user= userRepository.findById(idUsuario);
        if(user.isPresent()){
            return user.get().getContactoEmergencia();
        }
        else {
            throw new RuntimeException("Ese usuario no existe");
        }
    }
    public boolean isAdmin(Long idAdmin){
        Optional<User> user=userRepository.findById(idAdmin);
        if(user.isPresent()&&user.get().getRole().equals("ADMIN")) {
            return true;
        }
        return false;
    }

    public User hacerAdmin(Long idCliente){
        Optional<User> userCli=userRepository.findById(idCliente);
        if (userCli.isPresent()) {
            User userCLient = userCli.get();
            userCLient.setRole("ADMIN");
            return userRepository.save(userCLient);
        }
        else throw new RuntimeException("El usuario no existe");
    }

    public Optional<User> logIn(LoginDTO loginDto){
        Optional<User> userOp=userRepository.findByName(loginDto.getUsername());
        if(userOp.isPresent()&&userOp.get().getPassword().equals( loginDto.getPassword())){
            return userOp;
        }
        else {
            return Optional.empty();
        }
    }
}
