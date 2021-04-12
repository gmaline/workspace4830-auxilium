

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datamodel.User;
import util.UtilDB;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateUsers
 */
@WebServlet("/CreateUsers")
public class CreateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		Integer age = Integer.parseInt(request.getParameter("age").trim());
		//TODO Handle giving different types of roles different permissions.
		String role = request.getParameter("role").trim();
		String org = request.getParameter("organization").trim();
		
		// Check to see if that email already exists in the database.
		List<User> listUsers = null;
	      if (email != null && !email.isEmpty()) {
	         listUsers = UtilDB.listUsers(email);
	      }
	     //if there is not already a user, create the User and redirect to home page.
	      if (listUsers.isEmpty()) {
	  		UtilDB.createUsers(firstName, lastName, email, password, age, role, org);
	  		HttpSession session = request.getSession();
    		session.setAttribute("userEmail", email);
	  		response.sendRedirect(request.getContextPath() + "/HomePage.jsp");
	  	
	      }
	      //if there is already a user, display an error message.
	      else { 
	    	  response.sendRedirect(request.getContextPath() + "/BadCreateUser.jsp");
	      }

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
