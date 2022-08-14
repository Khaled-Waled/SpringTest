package com.test.controllers;

import com.test.dto.AuthRequestDTO;
import com.test.dto.AuthResponseDTO;
import com.test.entities.User;
import com.test.repository.UserRepository;
import com.test.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class AuthController
{
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request)
    {
        try
        {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponseDTO authResponse = new AuthResponseDTO(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(authResponse);
        }
        catch (BadCredentialsException ex)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody AuthRequestDTO request)
    {
        System.out.println("Entered create");
        try
        {
            User userEntity = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()));
            userRepository.save(userEntity);
            return ResponseEntity.ok().body("Saved");
        }
        catch (Exception e)
        {
            System.out.println("bad creds");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad creds");
        }
    }

}
