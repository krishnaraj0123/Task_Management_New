package com.example.TASK_MANAGER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.TASK_MANAGER")
public class TaskManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

}