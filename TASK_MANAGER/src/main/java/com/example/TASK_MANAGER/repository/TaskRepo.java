package com.example.TASK_MANAGER.repository;
import com.example.TASK_MANAGER.DTO.TaskDTO;
import com.example.TASK_MANAGER.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface  TaskRepo extends JpaRepository<Task,Long>{

	

	void save(TaskDTO task);

}
