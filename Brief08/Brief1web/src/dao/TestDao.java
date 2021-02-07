package dao;

import java.util.List;

import com.entities.Article;

public class TestDao {
	
	public static void main(String[] args) {
		
		ArticleDaoImpl dao = new ArticleDaoImpl();
		Article p1 = new Article("Lila", "joli fleur", 22, 21);
		dao.save(p1);	
		Article p2 = new Article("cactus", "ca pique", 40, 23);
		dao.save(p2);
		//Article p3 = dao.save(new Article("foug", "burk", 33, 31));
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("Chercher des produits");
		List<Article> arti= dao.search("%c%");
		for(Article p :arti) {
			System.out.println(p.toString());
		}
		
	}
 
}
