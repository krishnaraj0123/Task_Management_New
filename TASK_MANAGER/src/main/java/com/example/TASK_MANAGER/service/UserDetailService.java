package com.example.TASK_MANAGER.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {

	UserDetails loadUserByUsername(String username);

}
