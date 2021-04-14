package com.elbettal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.elbettal.model.AppRole;

@RepositoryRestResource //exposer les fonctionalités des users via l API REST 
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);
} 