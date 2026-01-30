package com.example.TASK_MANAGER.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.TaskDTO;
import com.example.TASK_MANAGER.DTO.UserDTO;
import com.example.TASK_MANAGER.Entity.Task;
import com.example.TASK_MANAGER.Entity.User;
import com.example.TASK_MANAGER.exception.UserNotFoundException;
import com.example.TASK_MANAGER.repository.TaskRepo;
import com.example.TASK_MANAGER.service.TaskService;

import jakarta.validation.Valid;
@Service
public class TaskServiceimpl implements TaskService {
	@Autowired
	private TaskRepo taskRepo;
	@Override
	public TaskDTO createTask(TaskDTO taskDTO) {
		Task task =new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setTaskStatus(taskDTO.getTaskStatus());	
		task.setUserid(taskDTO.getUserid());
		taskRepo.save(task);
		return taskDTO;
	}
	@Override
	public Page<TaskDTO> getAlltasks(@Valid int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Task> tasks = taskRepo.findAll(pageable);

		return tasks.map(task -> {
			TaskDTO dto = new TaskDTO();
			dto.setTitle(task.getTitle());
			dto.setDescription(task.getDescription());
			dto.setTaskStatus(task.getTaskStatus());
			dto.setUserid(task.getUserid());
			return dto;
		});

	}
	public TaskDTO getTaskById(Long id) {

	    Task task = taskRepo.findById(id)
	            .orElseThrow(() -> 
	                new UserNotFoundException("Task not found with id: " + id)
	            );

	    TaskDTO taskDTO = new TaskDTO();
	    taskDTO.setTitle(task.getTitle());
	    taskDTO.setDescription(task.getDescription());
	    taskDTO.setTaskStatus(task.getTaskStatus());
	    taskDTO.setUserid(task.getUserid());

	    return taskDTO;
	}
	@Override
	public TaskDTO updateTask(@Valid Long id, TaskDTO taskDTO) {
		Task task=taskRepo.findById(id).orElseThrow(() -> new UserNotFoundException("task not found"));
		TaskDTO tasks=new TaskDTO();
		tasks.setTitle(task.getTitle());
		tasks.setDescription(task.getDescription());
		tasks.setTaskStatus(task.getTaskStatus());
		tasks.setUserid(task.getUserid());
	
		return null;
	}
	@Override
	public void deleteTask(@Valid Long id) {
		Task task=taskRepo.findById(id).orElseThrow(() -> new UserNotFoundException("task not found"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	}


	


