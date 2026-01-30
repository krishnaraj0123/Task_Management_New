package com.example.TASK_MANAGER.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private String TaskStatus;
    private Long Userid;
	
	
	public Task(long id, String title, String description, String taskStatus, Long userid) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		TaskStatus = taskStatus;
		Userid = userid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return TaskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		TaskStatus = taskStatus;
	}
	public Long getUserid() {
		return Userid;
	}
	public void setUserid(Long userid) {
		Userid = userid;
	}
	public Task() {
		super();
		
	}
	
    

   // @Enumerated(EnumType.STRING)
//    private TaskStatus status;
//    private Localdate dueDate;
//    @ManyToOne
//    @JoinColumn (name="assignedTo")
//    private User assignedTO;
//    private LocalDate createdAt;
//    private LocalDateTime updated;
//

}
