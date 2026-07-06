package com.erp.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.erp.demo.model.User;
import com.erp.demo.repo.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {

            if (userRepository.findByUsernameAndPassword("admin", "admin123").isEmpty()) {

                User user = new User();
                user.setUsername("admin");
                user.setPassword("admin123");

                userRepository.save(user);

                System.out.println("Default admin user created.");
            }
        };
    }
}