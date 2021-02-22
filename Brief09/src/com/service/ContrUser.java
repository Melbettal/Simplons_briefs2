package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entities.User;

import dao.SingletonConnection;

public class ContrUser {
	
	public Boolean login(String email,String mdp)
    {
        Connection connect = SingletonConnection.getConnection();
        Boolean utilisateur = false ;

        try {
            PreparedStatement ps = connect.prepareStatement("SELECT * FROM \"user\" WHERE \"Email\" = ? AND mdp = ?");
            System.out.println(ps);
            ps.setString(1, email);
            ps.setString(2, mdp);
            System.out.println(email + mdp);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	utilisateur = true;

            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return utilisateur;
    }
	 
	
}
