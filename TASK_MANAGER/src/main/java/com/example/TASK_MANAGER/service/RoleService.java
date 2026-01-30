package com.example.TASK_MANAGER.service;

import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.RoleDTO;
@Service
public interface RoleService {

	RoleDTO createRole(RoleDTO roleDTO);

	

}
