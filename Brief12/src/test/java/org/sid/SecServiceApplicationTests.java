package org.sid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.sid.dao.AppUserRepository;
import org.sid.entities.*;

@SpringBootTest
class SecServiceApplicationTests {
	
	@Autowired
	private AppUserRepository appUserRepository;

	/*@Test
	void saveUserTest() {
		appUserRepository.save(new AppUser(null, "  ", "", "",  "",new ArrayList<>()));
		assertThat(appUserRepository.findByUsername("")).isNotNull();
	}*/
	
	/*@Test
	void updateUserTest() {
		AppUser user = appUserRepository.findByUsername("user2");
		if(user!=null) {
			user.setUserName("user5");
			appUserRepository.save(user);
			AppUser user1 = appUserRepository.findByUsername("user2");
			assertThat("user2").isEqualTo(user1.getFirstName());
		}
	}*/
	
	@Test
	void deleteUserTest() {
		AppUser user = appUserRepository.findByUsername("user3");
		if(user!=null) {
			appUserRepository.delete(user);
			assertThat(appUserRepository.findByUsername("user3")).isNull();
		}
	}
	
	@Test
	void getAllUserTest() {
		List<AppUser> users = appUserRepository.findAll();
		assertThat(0).isNotEqualTo(users.size());
	}
	
	

}