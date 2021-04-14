
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
import javax.servlet.http.HttpSession;

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
	    	if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
	    		HttpSession session = request.getSession();
	    		session.setAttribute("userEmail", user.getEmail());
	    		passwordFound = true;
	    	}
	    }
	    // Display an error if the password is not there or if the user is not there.
	    if (!passwordFound) {
	    	response.sendRedirect(request.getContextPath() + "/BadSignIn.jsp");
	    }
	    // If the password matches the user, redirect to the home page.
	    else {
	    	
	    	//=======================================================================
	    	/**The Following code is added by Wisdom. 
	    	 * It is used in order to display the profile of the current user.
	    	 */
	    	//	UtilDB.logIn(email); //Saves the Email of the Currently Logged In User.
	    	HttpSession session = request.getSession();
	        session.setAttribute("email", email);
	    	/**
	    	 * End of the Wisdom Code. Thank you for your Understanding :)
	    	 */
	    	//=========================================================================
	    		
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
