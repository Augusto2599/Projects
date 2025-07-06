package com.augusto.login_signin.service;

import com.augusto.login_signin.dto.RegisterRequest;
import com.augusto.login_signin.model.User;
import com.augusto.login_signin.repository.UserRepository;
import com.augusto.login_signin.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(RegisterRequest request) {
        // Evitar cadastro duplicado
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return false;
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(PasswordUtils.hashPassword(request.getPassword()));

        userRepository.save(newUser);
        return true;
    }
}
