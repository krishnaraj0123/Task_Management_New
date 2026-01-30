package com.example.TASK_MANAGER.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.UserDTO;

@Service
public interface UserService {
	Page<UserDTO> getAllUsers(int page, int size);

	UserDTO createUser(UserDTO userDTO);

	UserDTO updateUser(Long id, UserDTO userDTO);

	void deleteUser(Long id);

	UserDTO getUserById(Long id);

}
