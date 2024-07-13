package com.park.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.park.domain.User;
import com.park.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String telefone) throws UsernameNotFoundException {
        User user = userRepository.findByTelefone(telefone)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with phone: " + telefone));

        return new org.springframework.security.core.userdetails.User(user.getTelefone(), user.getSenha(), new ArrayList<>());
    }
}
