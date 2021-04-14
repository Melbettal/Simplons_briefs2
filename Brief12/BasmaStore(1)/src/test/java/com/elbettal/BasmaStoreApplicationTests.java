package com.elbettal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.elbettal.model.AppUser;
import com.elbettal.service.AccountService;

@SpringBootTest
class BasmaStoreApplicationTests {
	
	@Autowired
	AccountService accountService;

	@Test
	public void loadUserByUsernameTest() {
		AppUser user = accountService.loadUserByUsername("user1");
		assertNotNull(user);
	}

}
