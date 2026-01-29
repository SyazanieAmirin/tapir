package com.syazanie.tapir.controller;

import com.syazanie.tapir.dto.LoginRequest;
import com.syazanie.tapir.dto.RegisterRequest;
import com.syazanie.tapir.entity.User;
import com.syazanie.tapir.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
// @CrossOrigin(origins = "http://localhost:5173") // Use this if CorsConfig doesn't work
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        // The frontend sends { name, email, password }
        // We accept it as RegisterRequest
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.loginUser(request);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}