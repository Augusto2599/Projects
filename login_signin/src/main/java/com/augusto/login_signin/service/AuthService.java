package com.augusto.login_signin.service;

import com.augusto.login_signin.dto.LoginRequest;
import com.augusto.login_signin.repository.UserRepository;
import com.augusto.login_signin.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> PasswordUtils.match(request.getPassword(), user.getPassword()))
                .orElse(false);

    }
}