package com.elbettal.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elbettal.dao.AppRoleRepository;
import com.elbettal.dao.AppUserRepository;
import com.elbettal.model.AppRole;
import com.elbettal.model.AppUser;

@Service("accountService")
@Transactional

public class AccountServiceImpl implements AccountService{

	private AppUserRepository appUserRepository;
	private AppRoleRepository appRoleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,  BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;	
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	
	@Override
	public AppUser saveUser(String username, String password, String Cmdp) {
		AppUser  user = appUserRepository.findByUsername(username);
		if(user!=null) 
			throw new RuntimeException("User already exists"); 	//verifier si lemail existe
        if(!password.equals(Cmdp)) 
        	throw new RuntimeException("Please enter a similar password");  //verifier si le mdp existe
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
	}

	@Override
	public AppRole save(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		//AppUser appUser=appUserRepository.findByUsername(username);
		//System.out.println("aaaaaaaaaaaaa "+appUser.toString());
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		  AppUser appUser=appUserRepository.findByUsername(email); //chercher le user
	      AppRole appRole=appRoleRepository.findByRoleName(roleName); //chercher son role
	      appUser.getRoles().add(appRole);		 // ajouter le role a lutilisateur
	}

}
