package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entities.User;
import com.entities.Produit;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkLogin(User u) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps2;
		try {
			ps2 = connection.prepareStatement
					("SELECT * FROM public.\"user\" WHERE \"Nom complet\"=? AND \"mdp\"=? ");
			ps2.setString(1, u.getNom_complet());
			ps2.setString(2, u.getMdp());
			ps2.executeUpdate(); //execution de la requêtte
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return u;
	}



	@Override
	public void validationEmail(String email) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void validationMdp(String mdp, String confmdp) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User insertSignup(User u) {
		// TODO Auto-generated method stub
		return null;
	}





	
	
	
	
}
