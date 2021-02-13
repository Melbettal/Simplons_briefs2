package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entities.User;

import dao.SingletonConnection;

public class ContrUser {
	
	

	// insertion des données du signup
	
	public User insertSignup(User u ) {
			// TODO Auto-generated method stub
			Connection connection = SingletonConnection.getConnection();
			PreparedStatement ps;
			//PreparedStatement ps2;
			try {
				ps = connection.prepareStatement("INSERT INTO \"user\" (\"Nom complet\", \"Email\", \"mdp\") VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, u.getNom_complet());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getMdp());
				System.out.println(ps);
				ps.executeUpdate(); //execution de la requêtte
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return u;
		}
	
	
	//selection from database to login
	
	 public User login(String email,String mdp)
	    {
	        Connection connect = SingletonConnection.getConnection();
	        User utilisateur = null ;

	        try {
	            PreparedStatement ps = connect.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND MDP = ?");
	            ps.setString(1, email);
	            ps.setString(2, mdp);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	                utilisateur = new User();
	                utilisateur.setId(rs.getInt("id"));
	                utilisateur.setEmail(rs.getString("email"));
	                utilisateur.setNom_complet(rs.getString("nom"));
	                try {
	                    utilisateur.setMdp(rs.getString("mdp"));
	    	            System.out.println("im in");

	                } catch (Exception e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
				//System.out.println(ps);

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return utilisateur;
	    }
	
}
