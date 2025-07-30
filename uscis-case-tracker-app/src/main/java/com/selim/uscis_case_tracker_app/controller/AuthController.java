package com.selim.uscis_case_tracker_app.controller;

import com.selim.uscis_case_tracker_app.dto.LoginRequest;
import com.selim.uscis_case_tracker_app.dto.RegisterRequest;
import com.selim.uscis_case_tracker_app.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostConstruct
    public void init() {
        System.out.println("🚨 AuthController INIT çalıştı!");
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok("Bu, yalnızca giriş yapan kullanıcılar içindir.");
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("🔥 TEST endpoint reached");
        return ResponseEntity.ok("Test başarılı");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        System.out.println("REGISTER method called");
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
