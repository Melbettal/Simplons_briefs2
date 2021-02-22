package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entities.Produit;

public class ProduitDaoImpl implements ProduitDao {
	
	
	
	@Override
	public Produit save(Produit p) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			String query="INSERT INTO \"produit\" ( image, nom, description, prix, quantite) VALUES (?, ?, ?, ?, ?)";
			 ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, p.getImage());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getDescription());
			ps.setDouble(4, p.getPrix());
			ps.setInt(5, p.getQuantite());
			ps.executeUpdate();//execution de la requêtte
			
			
			ps2 = connection.prepareStatement
					("SELECT MAX(ID) AS \"MAX_ID\" FROM \"produit\"");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Produit> search(String s) {
		List <Produit> produits = new ArrayList<Produit>();
	Connection connection = SingletonConnection.getConnection();
	try {
		PreparedStatement ps = connection.prepareStatement
				("SELECT * FROM \"produit\" WHERE \"nom\" LIKE ?"); 
		ps.setString(1, s); 
		ResultSet rs = ps.executeQuery(); 
		while(rs.next()) { 
			Produit p =new Produit(); 
			p.setId(rs.getInt("id"));
			p.setImage(rs.getString("image"));
			p.setNom(rs.getString("nom"));
			p.setDescription(rs.getString("description"));
			p.setPrix(rs.getDouble("prix"));
			p.setQuantite(rs.getInt("quantite"));	
			produits.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return produits;
	}
	

	@Override
	public Produit getProduit(int id) {
		Produit p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM \"produit\" WHERE ID=?"); // search by id
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) { 
				p =new Produit(); 
				p.setId(rs.getInt("id"));
				p.setImage(rs.getString("image"));
				p.setNom(rs.getString("nom"));
				p.setDescription(rs.getString("description"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return p;
	}


	@Override
	public Produit update(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement
					("UPDATE \"produit\" SET image = ?, nom = ?, description = ?, prix = ?, quantite = ? WHERE id = ?");
			ps.setString(1, p.getImage());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getDescription());
			ps.setDouble(4, p.getPrix());
			ps.setInt(5, p.getQuantite());
			ps.setInt(6, p.getId());
			ps.executeUpdate(); //execution de la requêtte
			
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	
	@Override
		public Produit deleteProduit(int id) {
			// TODO Auto-generated method stub
					Connection connection = SingletonConnection.getConnection();
					
					try {
						PreparedStatement ps = connection.prepareStatement
								("DELETE FROM \"produit\" WHERE id = ? ");
						ps.setInt(1, id);
						ps.executeUpdate();
						ps.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				return null;
		}


	
	
	
	
	
	
	

}
