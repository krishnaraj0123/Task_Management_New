package com.example.TASK_MANAGER.DTO;

public class TaskDTO {
    private String title;
    private String description;
    private String taskStatus;
    private Long userid;
	public TaskDTO(String title, String description, String taskStatus, Long userid) {
		super();
		this.title = title;
		this.description = description;
		this.taskStatus = taskStatus;
		this.userid = userid;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
