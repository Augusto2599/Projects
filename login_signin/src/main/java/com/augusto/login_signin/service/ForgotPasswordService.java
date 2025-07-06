package com.augusto.login_signin.service;

import com.augusto.login_signin.dto.ForgotPasswordRequest;
import com.augusto.login_signin.model.User;
import com.augusto.login_signin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    public boolean resetPassword(ForgotPasswordRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(request.getNewPassword()); // depois vamos criptografar
            userRepository.save(user);
            return true;
        }

        return false;
    }
}