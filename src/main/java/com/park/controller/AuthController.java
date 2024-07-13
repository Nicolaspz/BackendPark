package com.park.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.domain.User;
import com.park.service.TokenService; 
import com.park.tdo.LoginRequestDTO;
import com.park.tdo.ResponseDTO;
import com.park.tdo.RegisterRequestDTO;

import com.park.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        User user = this.repository.findByTelefone(body.getTelefone()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.getPassword(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        Optional<User> existingUser = repository.findByTelefone(body.getTelefone());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body(new ResponseDTO("Este telefone já está registrado.", null));
        }

        User newUser = new User();
        newUser.setSenha(passwordEncoder.encode(body.getPassword()));
        newUser.setTelefone(body.getTelefone());
        newUser.setNome(body.getName());
        repository.save(newUser);

        String token = tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
    }
}