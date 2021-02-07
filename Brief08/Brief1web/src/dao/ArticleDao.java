package dao;

import java.util.List;

import com.entities.Article;

public interface ArticleDao {
	public Article save(Article p);
	public List<Article> search(String s);
	public Article getArticle(Long id);
	public Article deleteArticle(Long id);
	public Article update(Article p);

}
