package web;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.entities.Article;
import com.mysql.cj.exceptions.DataConversionException;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import web.ArticleModel;

@WebServlet(name="cs", urlPatterns= {"*.do"})
public class ControleurServlet extends HttpServlet {

	private ArticleDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ArticleDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/index.do")){
			request.getRequestDispatcher("Articles.jsp").forward(request, response ); //transmettre les deux objets
		}	
		else if (path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ArticleModel model = new ArticleModel();
			model.setMotCle(motCle);
			List<Article> articles = metier.search("%"+motCle+"%");
			model.setArticles(articles);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Articles.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if(path.equals("/Saisie.do")) {
			request.setAttribute("article", new Article()); //récuperer la forme de l'input
			request.getRequestDispatcher("SaisieArticle.jsp").forward(request, response ); 
		}	
		else if(path.equals("/SaveArticle.do") && (request.getMethod().equals("POST"))) { //pour récupérer les mêmes donner a fin de l'éditer
			//test pour savoir si il accepte la dopost non pas doget
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Article p = metier.save(new Article(nom, description, prix, quantite));
			request.setAttribute("article", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);	
		}	
		else if(path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteArticle(id);
			//request.getRequestDispatcher("Articles.jsp").forward(request, response);	
			response.sendRedirect("chercher.do?motCle=");
		}
		else if(path.equals("/edit.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Article p=metier.getArticle(id);
			request.setAttribute("article", p);
			request.getRequestDispatcher("EditArticles.jsp").forward(request, response);	
			//response.sendRedirect("chercher.do?motCle=");
		}
		else if(path.equals("/UpdateArticle.do") && (request.getMethod().equals("POST"))) { //test pour savoir si il accepte la dopost non pas doget
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Article p = new Article(nom, description, prix, quantite);
			p.setId(id);
			metier.update(p);
			request.setAttribute("article", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);	
		}	
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
