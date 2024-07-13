package com.park.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.park.domain.User;

@Service
public class TokenService {
	 @Value("${api.security.token.secret}")
	    private String secret;

	    public String generateToken(User user) {
	        try {
	            Algorithm algorithm = Algorithm.HMAC256(secret);
	            return JWT.create()
	                .withIssuer("park")
	                .withSubject(user.getTelefone())
	                .withExpiresAt(generateExpirationDate())
	                .sign(algorithm);
	        } catch (JWTCreationException e) {
	            throw new RuntimeException("Erro ao gerar token", e);
	        }
	    }

	    public String validateToken(String token) {
	        try {
	            Algorithm algorithm = Algorithm.HMAC256(secret);
	            return JWT.require(algorithm)
	                    .withIssuer("park")
	                    .build()
	                    .verify(token)
	                    .getSubject();
	        } catch (JWTVerificationException e) {
	            return null;
	        }
	    }

	    private Instant generateExpirationDate() {
	        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
	    }

	    public boolean validateToken(String token, UserDetails userDetails) {
	        String username = validateToken(token);
	        return username != null && username.equals(userDetails.getUsername());
	    }
	}