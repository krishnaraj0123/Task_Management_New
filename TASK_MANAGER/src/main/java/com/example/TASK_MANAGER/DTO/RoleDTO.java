package com.example.TASK_MANAGER.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDTO {
	
    @NotBlank(message = "rolename is required")
    private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleDTO(@NotBlank(message = "rolename is required") String roleName) {
		super();
		this.roleName = roleName;
	}

	public RoleDTO() {
		super();
	}

	
   
}
