package  com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClientDao;
import com.dao.ClientDaoImpl;

@WebServlet("/login")
public class SigninController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDao signinDao;

    public void init() {
    	signinDao = new ClientDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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