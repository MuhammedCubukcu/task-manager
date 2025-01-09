package com.muhammedcbkc.task_management.controller;

import com.muhammedcbkc.task_management.dto.AuthRequest;
import com.muhammedcbkc.task_management.dto.AuthResponse;
import com.muhammedcbkc.task_management.security.JwtTokenUtil;
import com.muhammedcbkc.task_management.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        String token = jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(authRequest.getUsername()));
        return ResponseEntity.ok(new AuthResponse(token));
    }
}