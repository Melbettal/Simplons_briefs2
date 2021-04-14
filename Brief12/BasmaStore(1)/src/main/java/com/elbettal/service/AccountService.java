package com.elbettal.service;

import com.elbettal.model.AppRole;
import com.elbettal.model.AppUser;

public interface AccountService {
	public AppUser saveUser(String username, String password, String Cmdp);
	public AppRole save(AppRole role);
	public AppUser loadUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);
	
	
	
}
