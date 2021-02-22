package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entities.Vote;
import com.entities.User;

import dao.SingletonConnection;

public class ContrVote {
	public Vote checkVote(Vote VP) {
        Connection connect = SingletonConnection.getConnection();	
        String query = "SELECT count(*) as \"nbrVote\" from  \"vote\" ,\"user\" where id=id_user and id_user=? and  id_produit=? " ;

        int cpt = -99 ;
        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setInt(1,VP.getId_user());
            ps.setInt(2,VP.getId_produit());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                 cpt = rs.getInt("nbrVote");
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(cpt);
        if(cpt>0)
        {
            return null;
        }
        else return VP;

    }
	
	
	public Vote saveVote(Vote VP) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			String query="INSERT INTO vote ( id_user, id_produit, date) VALUES (?, ?, NOW())";
			 ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, VP.getId_user());
			ps.setInt(2, VP.getId_produit());
			
			ps.executeUpdate();//execution de la requêtte
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VP;

    }
}
