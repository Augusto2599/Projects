package com.augusto.login_signin.service;

import com.augusto.login_signin.dto.ForgotPasswordRequest;
import com.augusto.login_signin.model.User;
import com.augusto.login_signin.repository.UserRepository;
import com.augusto.login_signin.utils.PasswordUtils;
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
            user.setPassword(PasswordUtils.hashPassword(request.getNewPassword()));
            userRepository.save(user);
            return true;
        }

        return false;
    }
}