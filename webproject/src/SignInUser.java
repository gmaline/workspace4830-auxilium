
import datamodel.*;
import java.util.List;
import util.UtilDB;
import java.io.IOException;
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
	    for (User user : listUsers) {
	    	if (user.getPassword() == password) {
	    		passwordFound = true;
	    	}
	    }
	    if (!passwordFound) {
	    	//TODO Deliver to login page + a email or password incorrect page
	    }
	    else {
	    	//TODO Redirect to home page.
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
