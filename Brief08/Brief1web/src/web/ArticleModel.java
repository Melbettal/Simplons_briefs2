package web;

import java.util.ArrayList;
import java.util.List;

import com.entities.Article;

public class ArticleModel {
	private String MotCle;
	private List<Article> articles= new ArrayList<Article>();
	
	
	public String getMotCle() {
		return MotCle;
	}
	public void setMotCle(String motCle) {
		MotCle = motCle;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
	
}
