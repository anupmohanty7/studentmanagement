package com.erp.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.demo.model.User;
import com.erp.demo.repo.UserRepository;
import com.erp.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(User user) {

        Optional<User> existingUser =
                userRepository.findByUsernameAndPassword(
                        user.getUsername(),
                        user.getPassword()
                );

        if (existingUser.isPresent()) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}