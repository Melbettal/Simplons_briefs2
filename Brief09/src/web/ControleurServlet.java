package web;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.entities.Produit;
import com.entities.User;
import com.mysql.cj.exceptions.DataConversionException;

import dao.UserDao;
import dao.UserDaoImpl;
import com.service.ContrUser;

@WebServlet(name="cs", urlPatterns= {"*.do"})
public class ControleurServlet extends HttpServlet {

	private UserDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new UserDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/Signin.do")){
			request.getRequestDispatcher("Signin.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if(path.equals("/Signup.do")){
			request.getRequestDispatcher("Signup.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if(path.equals("/Saisie.do")) {
			request.setAttribute("user", new User(0, path, path, path)); //récuperer la forme de l'input
			request.getRequestDispatcher("SaisieArticle.jsp").forward(request, response ); 
		}	
		else if(path.equals("/Saveuser.do") && (request.getMethod().equals("POST"))) { //pour récupérer les mêmes donner a fin de l'éditer
			//test pour savoir si il accepte la dopost non pas doget
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			System.out.println(nom +" "+ email+" "+mdp);
			User us=new User(nom, email, mdp);
			UserDaoImpl impl = new UserDaoImpl();
			impl.insertSignup(us);
		//	User u = metier.insertSignup(us);
			request.setAttribute("user", us);
			request.getRequestDispatcher("Signin.jsp").forward(request, response);	
		}	
		else if(path.equals("/Signin.do") && request.getMethod().equals("POST"))
        {
			 ContrUser SU = new ContrUser();
             String email = request.getParameter("email");
             String mdp = request.getParameter("mdp");
             User user = SU.login(email, mdp);          		
           if(user != null)
           {
               request.setAttribute("user", user);
               request.getRequestDispatcher("Produit.jsp").forward(request, response);

           }
           else
           {
               String msgGeneral = "Email ou mot de passe incorrect";
               String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
               String targetLink = "Login.jsp";

               request.setAttribute("msgGeneral", msgGeneral);
               request.setAttribute("targetLink", targetLink);
               request.setAttribute("msgLink", msgLink);
               request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
           }}

        }
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//private void validationEmail( String email ) throws Exception{}
    //private void validationMdp( String mdp, String confmdp ) throws Exception{}
}
