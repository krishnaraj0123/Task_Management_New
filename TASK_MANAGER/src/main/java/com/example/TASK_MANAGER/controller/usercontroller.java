package com.example.TASK_MANAGER.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TASK_MANAGER.DTO.UserDTO;
import com.example.TASK_MANAGER.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users/")

public class usercontroller {
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO saveduser = userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/all")
	public ResponseEntity<Page<UserDTO>>getAllUsers(@Valid @RequestParam int page, int size) {
		Page<UserDTO> users = userService.getAllUsers(page, size);
		return ResponseEntity.ok().body(users);
	}
	
 
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@Valid @PathVariable Long id) {
		UserDTO users = userService.getUserById(id);
		return ResponseEntity.ok().body(users);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable Long id, @RequestBody UserDTO userDTO) {
		UserDTO upadateuser = userService.updateUser(id, userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@Valid @PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();

	}

}
