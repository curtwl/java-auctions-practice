package com.curtwl.auctions.security;

import com.curtwl.auctions.model.User;
import com.curtwl.auctions.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println(user);
        try {
            Authentication authentication = authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                    .signWith(secretKeyFor(SignatureAlgorithm.HS512))
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        System.out.println(user);
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
