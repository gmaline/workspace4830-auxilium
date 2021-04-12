
import datamodel.*;
import java.util.List;
import util.UtilDB;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignInUser
 */
@WebServlet("/SignInUser")
public class SignInUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		
		List<User> listUsers = null;
	      if (email != null && !email.isEmpty()) {
	         listUsers = UtilDB.listUsers(email);
	      }
	    boolean passwordFound = false;
	    // Check that the user matches the given password.
	    for (User user : listUsers) {
	    	if (user.getPassword() == password) {
	    		passwordFound = true;
	    	}
	    }
	    // Display an error if the password is not there or if the user is not there.
	    if (!passwordFound) {
	    	
	    	request.setAttribute("error", "Username or password not correct.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignIn.jsp");
			dispatcher.forward(request, response);
	    }
	    // If the password matches the user, redirct to the home page.
	    else {
	    	response.sendRedirect(request.getContextPath() + "/HomePage.jsp");
	    }
	    	
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
