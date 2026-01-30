package com.example.TASK_MANAGER.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.RoleDTO;
import com.example.TASK_MANAGER.Entity.Role;
import com.example.TASK_MANAGER.repository.RoleRepo;
import com.example.TASK_MANAGER.service.RoleService;
@Service
public class RoleServiceimpl implements RoleService {
	
	@Autowired
    private RoleRepo roleRepo;

	@Override
	public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = new Role();
	    role.setRoleName(roleDTO.getRoleName());
        roleRepo.save(role); 
        return roleDTO;
	}


}
