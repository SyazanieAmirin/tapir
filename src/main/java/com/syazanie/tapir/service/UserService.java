package com.syazanie.tapir.service;

import com.syazanie.tapir.dto.LoginRequest;
import com.syazanie.tapir.dto.RegisterRequest;
import com.syazanie.tapir.entity.User;
import com.syazanie.tapir.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegisterRequest request) {
        // Map DTO to Entity
        // NOTE: We are using the email as the unique 'user_name'
        User newUser = new User();
        newUser.setUserName(request.getEmail());
        newUser.setUserPassword(request.getPassword()); // In real app, hash this!
        newUser.setUserRole("STAFF"); // Default role to prevent 500 Error

        return userRepository.save(newUser);
    }

    public User loginUser(LoginRequest request) {
        // 1. Find user by email (userName)
        User user = userRepository.findByUserName(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Check password (Simple check for assignment)
        if (!user.getUserPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}