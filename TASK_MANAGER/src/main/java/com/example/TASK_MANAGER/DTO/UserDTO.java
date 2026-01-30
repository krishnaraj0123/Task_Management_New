package com.example.TASK_MANAGER.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String Password;
    
	@Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
	
    @NotNull(message = "Role is required")
    private String role;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public UserDTO(@NotBlank(message = "Username is required") String username,
			@NotBlank(message = "Password is required") String password,
			@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email,
			@NotNull(message = "Role is required") String role) {
		super();
		this.username = username;
		Password = password;
		this.email = email;
		this.role = role;
	}


	public UserDTO() {
		super();
	}
	
	
	
    
	
}