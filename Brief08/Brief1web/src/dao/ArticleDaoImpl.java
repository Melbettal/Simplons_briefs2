package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public Article save(Article p) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = connection.prepareStatement
					("INSERT INTO ARTICLE (NOM, DESCRIPTION, PRIX, QUANTITE) VALUES (?, ?, ?, ?)");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate(); //execution de la requêtte
			
			
			ps2 = connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM ARTICLE");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Article> search(String s) {
		List <Article> articles = new ArrayList<Article>();
	Connection connection = SingletonConnection.getConnection();
	try {
		PreparedStatement ps = connection.prepareStatement
				("SELECT * FROM ARTICLE WHERE NOM LIKE ?"); // search by description
		ps.setString(1, s); //designer le paramètre
		ResultSet rs = ps.executeQuery(); //execution de la requette
		while(rs.next()) { //parcourir les resultats ligne par ligne
			Article p =new Article(s, s, 0, 0); //mapping objet relationelle
			p.setId(rs.getLong("ID"));
			p.setNom(rs.getString("NOM"));
			p.setDescription(rs.getString("DESCRIPTION"));
			p.setPrix(rs.getLong("PRIX"));
			p.setQuantite(rs.getInt("QUANTITE"));	
			articles.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return articles;
	}

	@Override
	public Article getArticle(Long id) {
		Article p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ARTICLE WHERE ID=?"); // search by id
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) { 
				p =new Article(); 
				p.setId(rs.getLong("ID"));
				p.setNom(rs.getString("NOM"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrix(rs.getLong("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return p;
	}

	@Override
	public Article update(Article p) {
		Connection connection = SingletonConnection.getConnection();
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = connection.prepareStatement
					("UPDATE  ARTICLE SET NOM=?, DESCRIPTION=?, PRIX=?, QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getDescription());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.setLong(5, p.getId());
			ps.executeUpdate(); //execution de la requêtte
			
			
			ps2 = connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM ARTICLE");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Article deleteArticle(Long id) {
		// TODO Auto-generated method stub
				Connection connection = SingletonConnection.getConnection();
				
				try {
					PreparedStatement ps = connection.prepareStatement
							("DELETE FROM ARTICLE WHERE ID=? ");
					ps.setLong(1, id);
					ps.executeUpdate();
					ps.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			return null;
	}

	
	
}
