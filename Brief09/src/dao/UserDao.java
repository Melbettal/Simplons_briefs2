package dao;

import com.entities.Produit;
import com.entities.User;

public interface UserDao {
	
	public void validationEmail( String email ) ;
	public void validationMdp (String mdp, String confmdp);
	User insertSignup(User u);
	User checkLogin(User u);
	User login(User u);
	//User login(String email, String mdp);

}
