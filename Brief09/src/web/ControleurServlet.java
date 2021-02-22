package web;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.Response;

import com.entities.Produit;
import com.entities.User;
import com.entities.Vote;
import com.form.SignupForm;
import com.service.ContrVote;
import com.mysql.cj.exceptions.DataConversionException;

import dao.UserDao;
import dao.UserDaoImpl;
import dao.ProduitDao;
import dao.ProduitDaoImpl;
import com.service.*;

@WebServlet(name="cs", urlPatterns= {"*.do", "/upload"})
@MultipartConfig


public class ControleurServlet extends HttpServlet {

	private UserDao metier;
	private ProduitDao metier1;
    User utilisateur = new User();
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/Signup.jsp";
	
	@Override
	public void init() throws ServletException {
		metier = new UserDaoImpl();
		metier1 = new ProduitDaoImpl();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/index.do")){
			request.getRequestDispatcher("Signup.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if(path.equals("/Saisie.do")) {
			request.setAttribute("user", new User(0, path, path, path)); //récuperer la forme de l'input
			request.getRequestDispatcher("SaisieArticle.jsp").forward(request, response ); 
		}	
		else if(path.equals("/Saveuser.do") && (request.getMethod().equals("POST"))) { 
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			System.out.println(nom +" "+ email+" "+mdp);
			User us=new User(nom, email, mdp);
			UserDaoImpl impl = new UserDaoImpl();
			impl.save(us);
		//	User u = metier.insertSignup(us);
			request.setAttribute("user", us);
			request.getRequestDispatcher("Signin.jsp").forward(request, response);	
		}	
		else if(path.equals("/Signin.do") && request.getMethod().equals("POST"))
        {
			 UserDaoImpl dao = new UserDaoImpl();
             String email = request.getParameter("email");
             String mdp = request.getParameter("mdp");
             User user = new User();
             user = dao.loginUser(email, mdp);
             utilisateur = user;
             if(email.equals("admin@gmail.com") && mdp.equals("admin123"))
             {
                 request.getRequestDispatcher("admin.jsp").forward(request, response);
             }
             else if(user.getId() != 0)
           {
               request.setAttribute("user", user);
               request.getRequestDispatcher("Produit.do").forward(request, response);
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
		else if(path.equals("/admin.do")){
			request.getRequestDispatcher("admin.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if (path.equals("/chercher.do")) {
				String motCle = request.getParameter("motCle");
				ProduitModel model = new ProduitModel();
				model.setMotCle(motCle);
				List<Produit> produits = metier1.search("%"+motCle+"%");
				model.setProduits(produits);
				request.setAttribute("model", model);
				request.getRequestDispatcher("admin.jsp").forward(request, response ); //transmettre les deux objets
			}
		else if(path.equals("/Saisie.do")) {
			request.setAttribute("article", new Produit(0, path, path, path, 0, 0)); //récuperer la forme de l'input
			request.getRequestDispatcher("ajoutProduit.jsp").forward(request, response ); 
		}
			
		else if(path.equals("/SaveArticle.do") && (request.getMethod().equals("POST"))) { 
			//String image = request.getParameter("image");
			String nom = request.getParameter("nom");
			String description  = request.getParameter("description");
			double prix  = Double.parseDouble(request.getParameter("prix"));
			int quantite  = Integer.parseInt(request.getParameter("quantite"));
			//
			 Part part  = request.getPart("image");
             String fileName = getSubmittedFileName(part);

             String filePath = ("C:\\Users\\Admin\\Web\\Brief2\\WebContent\\img"+File.separator+fileName);



             InputStream is = part.getInputStream();
             Boolean uploadedImgTest = saveFile(is,filePath);
             if(uploadedImgTest)
             {
                 System.out.println("image uploaded");
             }
             else
             {
                 System.out.println("image not uploaded");
             }

			//
			
			
			Produit p = metier1.save(new Produit(fileName, nom, description, prix, quantite));
			request.setAttribute("article", p);
			request.getRequestDispatcher("admin.jsp").forward(request, response);	
		}
		else if(path.equals("/UpdateProduit.do") && (request.getMethod().equals("POST"))) { //test pour savoir si il accepte la dopost non pas doget
			//String image = request.getParameter("image");
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			int id = Integer.parseInt(request.getParameter("id"));
			//
			 Part part  = request.getPart("image");
            String fileName = getSubmittedFileName(part);

            String filePath = ("C:\\Users\\Admin\\Web\\Brief2\\WebContent\\img"+File.separator+fileName);



            InputStream is = part.getInputStream();
            Boolean uploadedImgTest = saveFile(is,filePath);
            if(uploadedImgTest)
            {
                System.out.println("image uploaded");
            }
            else
            {
                System.out.println("image not uploaded");
            }

			//
			Produit p = new Produit(fileName, nom, description, prix, quantite);
			p.setId(id);
			metier1.update(p);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("admin.jsp").forward(request, response);	
		}	
		else if(path.equals("/edit.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Produit p=metier1.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);	
			//response.sendRedirect("chercher.do?motCle=");
		}
	
		else if(path.equals("/supprimer.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			metier1.deleteProduit(id);
			//request.getRequestDispatcher("Articles.jsp").forward(request, response);	
			response.sendRedirect("chercher.do?motCle=");
		}
		/*else if (path.equals("/chercherProduit.do")) {
			String InputVal = request.getParameter("InputVal");
			ProduitModel model = new ProduitModel();
			model.setMotCle(InputVal);
			List<Produit> produits = metier1.search("%"+InputVal+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Produit.jsp").forward(request, response ); //transmettre les deux objets
		}*/
		else if(path.equals("/Produit.do")) {
			String motCle = "";
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier1.search("%"+motCle+"%");
			model.setProduits((ArrayList<Produit>) produits);
			request.setAttribute("model", model);
			System.out.println(model);
			request.getRequestDispatcher("Produit.jsp").forward(request, response ); //transmettre les deux objets
			
		}
		
		else if(path.equals("/Vote.do"))
        {
            int idProduit = Integer.parseInt(request.getParameter("id"));
            int idUtilisateur = utilisateur.getId();

            ContrVote vpdi = new ContrVote();
            if(idUtilisateur !=0 )

            {
            	System.out.println("user logged");
                if(  vpdi.checkVote(new Vote(null, idUtilisateur,idProduit)) != null)
                {
                	 
                    vpdi.saveVote(new Vote(null, idUtilisateur,idProduit));
                    String msgGeneral = "Votre vote a été bien enregister ";
                       String msgLink = "Cliquer sur ce lien pour retourner a la page Home";
                       String targetLink = "index.asp";

                       request.setAttribute("msgGeneral", msgGeneral);
                       request.setAttribute("targetLink", targetLink);
                       request.setAttribute("msgLink", msgLink);
                       request.getRequestDispatcher("ConfirmUtilisateur.jsp").forward(request, response);

                }
                else
                {
                	 
                    String msgGeneral = "Vous avez déja voter pour ce Produit";
                       String msgLink = "Cliquer sur ce lien pour retourner a la page Home";
                       String targetLink = "index.asp";

                       request.setAttribute("msgGeneral", msgGeneral);
                       request.setAttribute("targetLink", targetLink);
                       request.setAttribute("msgLink", msgLink);
                       request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
                }

            }
            else
            {
            	 
                String msgGeneral = "Vous devriez vous connecter pour accéder à ce service";
                   String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
                   String targetLink = "Login.jsp";

                   request.setAttribute("msgGeneral", msgGeneral);
                   request.setAttribute("targetLink", targetLink);
                   request.setAttribute("msgLink", msgLink);
                   request.getRequestDispatcher("ErreurUtilisateur.jsp").forward(request, response);
            }
        }
		
		
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    public Boolean saveFile(InputStream is , String tagetPath)
    {
        Boolean ret = false;
        try 
        {
            byte[] byt = new byte[is.available()];
            is.read(byt);
            FileOutputStream fopt = new FileOutputStream(tagetPath);
            fopt.write(byt);
            fopt.flush();
            fopt.close();
            ret = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
