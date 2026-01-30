package com.example.TASK_MANAGER.repository;
import com.example.TASK_MANAGER.DTO.UserDTO;
import com.example.TASK_MANAGER.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	
	UserDTO save(UserDTO userDTO);

	Optional<User> findByUsername(String username);

}
