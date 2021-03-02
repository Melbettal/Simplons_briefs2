package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClientDao;
import com.dao.ClientDaoImpl;
import com.model.Client;

@WebServlet("/register")
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDao signupDao;

    public void init() {
    	signupDao = new ClientDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("register.jsp");
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
			
			signupDao.doHashing(mdp);
			
			System.out.println(mdp);

  	        signupDao.saveClient(client);

  	        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
  	        dispatcher.forward(request, response);
  	    }
}