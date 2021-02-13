package dao;

import com.entities.User;

public class Test {
	
	public static void main(String[] args) {
		
		
		UserDaoImpl dao = new UserDaoImpl();
		User u1 = new User(1, "mery", "meryame@gmail.com", "22BB");
		dao.insertSignup(u1);
		
		System.out.println(u1.toString());
	
	}

}
