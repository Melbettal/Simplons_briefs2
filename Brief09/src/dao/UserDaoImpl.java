package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User loginUser(String email,String mdp)
    {
        Connection connect = SingletonConnection.getConnection();
        User utilisateur = new User() ;

        try {
            PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"user\" WHERE \"Email\" = ? AND mdp = ?");
            ps.setString(1, email);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                //utilisateur = new User();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setEmail(rs.getString("Email"));
                utilisateur.setNom_complet(rs.getString("Nom complet"));
                try {
                    utilisateur.setMdp(rs.getString("mdp"));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            
            return utilisateur;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return utilisateur;
    }
	
	
	@Override
	public User save(User u) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = connection.prepareStatement
					("INSERT INTO \"user\" ( \"Nom complet\", \"Email\", \"mdp\") VALUES (?, ?, ?)");
			ps.setString(1, u.getNom_complet());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getMdp());
			ps.executeUpdate();//execution de la requêtte
			
			
			ps2 = connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM \"produit\"");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("MAX_ID"));
			}
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}





	@Override
	public void validationMdp(String mdp, String confmdp) {
		// TODO Auto-generated method stub
		
	}





	public void insertSignup(User us) {
		// TODO Auto-generated method stub
		
	}









	@Override
	public void validationEmail(String email) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User checkLogin(User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteProduit(int id) {
		// TODO Auto-generated method stub
		
	}





	
	
	
	
}
