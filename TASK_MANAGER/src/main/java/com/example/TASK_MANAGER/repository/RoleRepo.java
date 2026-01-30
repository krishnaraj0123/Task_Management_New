package com.example.TASK_MANAGER.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TASK_MANAGER.Entity.Role;

@Repository
public interface  RoleRepo extends JpaRepository<Role,Long>{


	
}


