package dao;

import java.util.List;

import com.entities.Produit;
import com.entities.User;

public interface UserDao {
	
	public void validationEmail( String email ) ;
	public void validationMdp (String mdp, String confmdp);
	public void insertSignup(User us);
	public User checkLogin(User u);
	public User save(User u);
	public User loginUser(String email, String mdp);
	public void deleteProduit(int id);

}
