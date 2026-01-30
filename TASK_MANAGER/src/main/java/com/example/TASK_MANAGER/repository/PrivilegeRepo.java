package com.example.TASK_MANAGER.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {
	
	

}
