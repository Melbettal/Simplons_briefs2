package org.sid.web;

import org.sid.entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RepositoryRestController
public class RepositoryControllerAppUser {

	@Autowired
	private AccountService accountService;
	
	@ResponseBody
	@PostMapping("/appUsers")
	private AppUser saveUser(@RequestBody UserForm user) {
		return accountService.saveUser(user.getUsername(), user.getPassword(), user.getConfirmedPassword());
	}
}
