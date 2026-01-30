package com.example.TASK_MANAGER.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TASK_MANAGER.DTO.RoleDTO;
import com.example.TASK_MANAGER.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@PostMapping("/create")
	public ResponseEntity<RoleDTO>createRole(@RequestBody RoleDTO roleDTO){
		RoleDTO savedroles=roleService.createRole(roleDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
//	@GetMapping("/all")
//	public ResponseEntity<RoleDTO>getallRole(@RequestBody RoleDTO roleDTO){
//		RoleDTO savedroles=roleService.getallRole(RoleDTO);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	
//	}
//	
	

}
