

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;

import datamodel.*;
import util.*;

/**
 * Servlet implementation class ProfileOrganization
 */
@WebServlet("ProfileOrganization")
public class ProfileOrganization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileOrganization() {
        super();
    }

//    @SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	User user = (User) request.getUserPrincipal(); //:TODO I do not know if this will work or NOT.
    	
    	if(true)//user.getRole().getRequest())		//If the User is with Organization, Proceed.
    	{
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String title = "Account Profile";
	        String docType = "<!DOCTYPE html>"; //
//	        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
	        
//:TODO	        String orgName = user.getOrgName();
//:TODO	        String orgRole = user.getOrgRole();
//	        String fname = user.getFirstName();
//	        String lname = user.getLastName();
//	        String email = user.getEmail();
	        
	        out.println(docType + "\n"
	              + "<html>\n"
	              + "<head>\n"
	              + "<meta charset=\"ISO-8859-1\">\r\n"
	              + "<title>Profile Page</title>\r\n"
	              + "<link rel=\"stylesheet\" href=\"style.css\" />\r\n"
	              + "</head>\r\n"
	              + "<div>\r\n"
	              + "	<h1>" + title + "</h1>\r\n"
	              + "	\r\n"
	              + "	</div>"
	              + "<nav>\r\n"
//	              + "<a href=\"/webproject/Listings.html\">All Listings</a> <br>\r\n"
	              + "</nav>"
	              + "<body>\r\n"
	              + "	<main>\r\n"
	              + "	<div id=\"container\">\r\n"
	              + "		\r\n"
	              + "		<div style=\"width:100%\">"
	              + "<br />"
/*	              + "\r\n Organization Name: " + orgName + "<br />"
	              + "<br />"
	              + "\r\n Role in Organization: " + orgRole + "<br />"
	              + "<br />"
	              + "\r\n First Name: " + fname + "<br />"
	              + "<br />"
	              + "\r\n Last Name: " + lname + "<br />"
	              + "<br />"
	              + "\r\n Email Address: " + email + "<br />"
*/	              + "<br />"
	              + "	\r\n"
	              + "		</div>\r\n"
	              + "		\r\n"
	              + "	</div>\r\n"
	              + "	</main>\r\n"
	              + "</body>\r\n"
	              + "</html>"
	        						);  
	     }
		 else //If the User is Individual, call ProfilePersonal
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("ProfileIndividual");
			 rd.forward(request,response);
		 }
     }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
     }
  }
