package com.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.park.domain.Role;
import com.park.domain.User;
import com.park.domain.Vaga;
import com.park.service.UserService;
import com.park.tdo.ResponseVaga;
import com.park.tdo.userDTO;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
    public ResponseEntity<List<userDTO>> getAllUsers() {
        List<User> user = userService.findAll();
        List<userDTO> userDto = user.stream().map(this::convertToResponseUser).collect(Collectors.toList());
        return ResponseEntity.ok(userDto);
        
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
	    Optional<User> existingUser = userService.findById(id);
	    if (existingUser.isPresent()) {
	        User updatedUser = existingUser.get();
	        updatedUser.setNome(user.getNome());
	        updatedUser.setTelefone(user.getTelefone());
	        updatedUser.setRole(user.getRole());
	      
	        
	        User savedUser = userService.save(updatedUser);
	        return ResponseEntity.ok(savedUser);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	 
	
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
        
        /*
         * User newUser = new User();
        newUser.setSenha(passwordEncoder.encode(body.getPassword()));
        newUser.setTelefone(body.getTelefone());
        newUser.setNome(body.getName());
        newUser.setRole(Role.USER);
        repository.save(newUser);*/
    }
    
   
    
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private userDTO convertToResponseUser(User user) {
    	
        return new userDTO(user.getNome(), user.getTelefone(),user.getRole(),user.getId());
    }
	
	

}
