package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.Response;

import com.dao.ClientDao;
import com.dao.ClientDaoImpl;
import com.dao.VetDao;
import com.dao.VetDaoImpl;
import com.model.Client;


//@WebServlet("/register")

@WebServlet(name="cs", urlPatterns= {"*.do", "/upload"})


public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDao signupDao;
    private ClientDao signinDao;

    public void init() {
    	signupDao = new ClientDaoImpl();
    	signinDao = new ClientDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
            try {
                authenticate(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }    
            }

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/Signup.jsp")){
			request.getRequestDispatcher("Signup.jsp").forward(request, response ); //transmettre les deux objets
		}
		else if (path.equals("/login"))
			//request.getRequestDispatcher("Signin.jsp").forward(request, response ); //transmettre les deux objets
	        response.sendRedirect("Signup.jsp");
	    
    }
    

    //Signup
	 private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 String nom_complet = request.getParameter("nom_complet");
	        String email = request.getParameter("email");
	        String mdp = request.getParameter("mdp");

	        Client client = new Client();
	        client.setNom_complet(nom_complet);
	        client.setEmail(email);
	        client.setMdp(mdp);

	        signupDao.saveClient(client);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	 //Signin
	 private void authenticate(HttpServletRequest request, HttpServletResponse response)
			    throws Exception {
			        String email = request.getParameter("email");
			        String mdp = request.getParameter("mdp");

			        if (signinDao.validate(email, mdp)) {
			            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			            dispatcher.forward(request, response);
			        } else {
			            throw new Exception("Login not successful..");
			        }
			    }
	
}