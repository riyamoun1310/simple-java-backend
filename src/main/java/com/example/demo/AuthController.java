package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://simple-java-frontendl.vercel.app")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User dbUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return Map.of("message", "Login successful!", "user", dbUser.getEmail());
        }
        return Map.of("message", "Invalid credentials");
    }
}
