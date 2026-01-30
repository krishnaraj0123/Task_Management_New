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

import com.example.TASK_MANAGER.DTO.TaskDTO;
import com.example.TASK_MANAGER.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	@PostMapping("/add")
	public ResponseEntity<TaskDTO>createTask(@RequestBody TaskDTO taskDTO){
		TaskDTO task=taskService.createTask(taskDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<TaskDTO>> getAlltask(@Valid @RequestParam int page,int size){
		Page<TaskDTO>tasks=taskService.getAlltasks(page,size);
			return ResponseEntity.ok().body(tasks);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO>getTaskById(@Valid @PathVariable Long id){
		TaskDTO tasks=taskService.getTaskById(id);
		return ResponseEntity.ok().body(tasks);	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TaskDTO>updateTask(@Valid @PathVariable Long id,@RequestBody TaskDTO taskDTO){
		TaskDTO upadatetask = taskService.updateTask(id, taskDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTask(@Valid @PathVariable Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();

	
	
	
	}	

	
}
