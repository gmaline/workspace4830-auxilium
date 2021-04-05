

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Organization;
import datamodel.Role;
import datamodel.User;
import util.UtilDB;

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
		Role role = new Role(request.getParameter("role").trim(), true, true);
		Organization organization = new Organization(request.getParameter("organization").trim());
		
		// Check to see if that email already exists in the database.
		List<User> listUsers = null;
	      if (email != null && !email.isEmpty()) {
	         listUsers = UtilDB.listUsers(email);
	      }
	      if (listUsers.isEmpty()) {
	  		UtilDB.createUsers(firstName, lastName, email, password, age, role, organization);
	      }
	      else { 
	    	  //TODO Display a "user email already exists try again" type message.
	      }

		//TODO Direct to the home page after 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
