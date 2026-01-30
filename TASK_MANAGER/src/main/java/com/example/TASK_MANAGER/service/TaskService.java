package com.example.TASK_MANAGER.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.TASK_MANAGER.DTO.TaskDTO;

import jakarta.validation.Valid;
@Service

public interface TaskService {

	TaskDTO createTask(TaskDTO taskDTO);

	Page<TaskDTO> getAlltasks(@Valid int page, int size);

	TaskDTO getTaskById(@Valid Long id);

	TaskDTO updateTask(@Valid Long id, TaskDTO taskDTO);

	void deleteTask(@Valid Long id);

}
