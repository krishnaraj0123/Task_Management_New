package com.example.TASK_MANAGER.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.UserDTO;
import com.example.TASK_MANAGER.Entity.User;
import com.example.TASK_MANAGER.exception.UserNotFoundException;
import com.example.TASK_MANAGER.repository.UserRepo;
import com.example.TASK_MANAGER.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Page<UserDTO> getAllUsers(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<User> users = userRepo.findAll(pageable);

		return users.map(user -> {
			UserDTO dto = new UserDTO();
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
			dto.setRole(user.getRole());
			return dto;
		});
	}

	public UserDTO createUser(UserDTO userDTO) {

		User user = new User();
		user.setUsername(userDTO.getUsername());

		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());

		userRepo.save(user);

		return userDTO;
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
		User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());
		userRepo.save(user);
		return userDTO;
	}

	@Override
	public void deleteUser(Long id) {
		if (!userRepo.existsById(id)) {
			throw new UserNotFoundException("User not found");
		}
		userRepo.deleteById(id);
	}

	@Override
	public UserDTO getUserById(Long id) {
		if (userRepo.findById(id).isPresent()) {
			User user = userRepo.findById(id).get();
			UserDTO dto = new UserDTO();
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
			dto.setRole(user.getRole());
			return dto;

		} else {
			throw new UserNotFoundException("User not found with id: " + id);

		}
	}

}
