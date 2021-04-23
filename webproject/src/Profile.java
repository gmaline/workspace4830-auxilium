

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;

import datamodel.*;
import util.*;

/**
 * Servlet implementation class ProfileOrganization
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
    }

//    @SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
    	
    	if(email != null)//If the User is Logged In, Proceed.
    	{
	        User user = UtilDB.FindUser(email);
	        
	        String fullName = user.getFirstName() + " " + user.getLastName();
	        String age = Integer.toString(user.getAge());
	        String org = user.getOrganization().toString(); //Already says "Organization:"
	        String role = user.getRole().getName(); //Already says "Role:"
 	        String title = "Account Profile";

    		List<Notification> notifs = UtilDB.getNotificationsForUser(user);    		
    		String notifications = "";
    		
    		if (notifs != null) {
    			notifications = "You have requests on the following items: ";
    			for (int i = 0; i < notifs.size(); i++) {
    				notifications += notifs.get(i).getDonation().getName() + ", ";
    			}
    		}
    		
    		request.setAttribute("fullName", fullName);
    		request.setAttribute("age", age);
    		request.setAttribute("org", org);
    		request.setAttribute("role", role);
    		request.setAttribute("title", title);
    		request.setAttribute("notifications", notifications);
    		request.setAttribute("notifs", notifs);
    		
    		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Profile.jsp");
    		rd.forward(request, response);
    		
	     }
		 else //If the User NOt Logged In, go back to Homepage
		 {
			 
		//	 request.setAttribute("errorMessage", "Please submit an amount of at least 1");
		//	 request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			 
			 response.setContentType("text/html");
	 	     PrintWriter out = response.getWriter();
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('You MUST Log In To View Your Profile!');");
			 out.println("location='SignIn.jsp';");
			 out.println("</script>");
			 
			 //response.sendRedirect(request.getHeader("Referer"));

			 //RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			 //rd.forward(request,response);
		 }
     }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
     }
  }



/*=======Drafts==========================
			If Statement  + Printer

		//UtilDB.logIn("me@key.org");	//Testing TODO
		HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");//.toString();
        //String email = (String)request.getAttribute("email");
		//String email = UtilDB.getLoggedInUser();	//Testing TODO
    	
        //email = "me@key.org";
    	if(email != null)//If the User is Logged In, Proceed.
    	{
	        User user = UtilDB.FindUser(email);
	        //User user = new User();	//Testing TODO
	        
	        String fullName = user.getFirstName() + " " + user.getLastName();
	        //String email = user.getEmail();
	        String age = Integer.toString(user.getAge());
	        String org = user.getOrganization().toString(); //Already says Organization:
	        String role = user.getRole().toString(); //Already says Role:
	        
    		response.setContentType("text/html");
 	        PrintWriter out = response.getWriter();
 	        String title = "Account Profile";
    		request.getRequestDispatcher("/Header.jsp").include(request, response);
    		request.getRequestDispatcher("/Navbar.jsp").include(request, response);

	        out.println("<title>Profile Page</title>\r\n"
	              + "</head>\r\n"
	              + "<div>\r\n"
	              + "	<h1>" + title + "</h1>\r\n"
	              + "	\r\n"
	              + "	</div>"
	              + "<body>\r\n"
	              + "	<main>\r\n"
	              + "	<div id=\"container\">\r\n"
	              + "		\r\n"
	              + "		<div style=\"width:100%\" >"
	              + "<section>\r\n"
	              + "<br />"
	              + "\r\n Full Name: "// + fullName + "<br />"
	              + "<br />"
	              + "\r\n Email: "// + email + "<br />"
	              + "<br />"
	              + "\r\n Age: "// + age + "<br />"
	              + "<br />"
	              + "\r\n" //+ org + "<br />"
	              + "<br />"
	              + "\r\n" //+ role + "<br />"
	              + "<br />"
	              + "</section>\r\n"
	              + "	\r\n"
	              + "		</div>\r\n"
	              + "		\r\n"
	              + "	</div>\r\n"
	              + "	</main>\r\n"
	              + "</body>\r\n"
	              + "</html>"
	        						);  			
====================================================
			From UtilDB
/***===================Code Below Under Testing=======================================
	static Session loggedIn = null;
	/*
	 * This function allows to display the profile
	 * It tells whether there is a user logged in or not.
	 * @param email
	 *
	public static void logIn(String email) {
	//	loggedIn = getSessionFactory().openSession();
    	((HttpSession) loggedIn).setAttribute("email", email); //Saves the email of the currently Logged In User
	}
	/**
	 * This function allows to display the profile
	 * It retrieves the email of the currently logged in User.
	 * @return loggedIn User's Email
	 *
	public static String getLoggedInUser() { //Returns the email of the currently Logger In User
		return ((HttpSession) loggedIn).getAttribute("email").toString();
	}
//===================Above Code Under Testing======================================
				

*/