

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.*;
import util.*;

/**
 * Servlet implementation class SubmitRequest
 */
@WebServlet("/SubmitRequest")
public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequest() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("item");
		
		HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        User asker = UtilDB.FindUser(email);	//Get the currently logged in User
		
		try {
			int item = ((Number)NumberFormat.getInstance().parse(id)).intValue(); //gets the integer value from the String
			
			Posting post = new Posting();
			post = UtilDB.FindListing(item);
			
			List<Notification> notifs = UtilDB.getNotificationsByPost(post);
			
			if(!asker.getRole().getRequest()) { //If user cannot request
				response.setContentType("text/html");
		 	    PrintWriter out = response.getWriter();
		 	     
		 	    String someMessage = "Individuals are NOT allowed to Request Items\\nMust be with an Organization to Request Items";
		 	    out.println("<script type='text/javascript'>");
		 	    out.println("alert(" + "'" + someMessage + "'" + ");");
		 	    out.println("location='HomePage.jsp';");
		 	    out.println("</script>");
		 	    out.println("</head><body></body></html>");
			}
			else if(post == null) {		//Item Not Found
				response.setContentType("text/html");
		 	    PrintWriter out = response.getWriter();
		 	     
		 	    String someMessage = "Item not found!\\nDouble Check Item Number";
		 	    out.println("<script type='text/javascript'>");
		 	    out.println("alert(" + "'" + someMessage + "'" + ");");
		 	    out.println("location='Request.jsp';");
		 	    out.println("</script>");
		 	    out.println("</head><body></body></html>");
			}
			else if (asker.getId() == post.getUser().getId()) {
				response.setContentType("text/html");
		 	    PrintWriter out = response.getWriter();
		 	    
				String someMessage = "Cannot request your own item";
		 	    out.println("<script type='text/javascript'>");
		 	    out.println("alert(" + "'" + someMessage + "'" + ");");
		 	    out.println("location='Request.jsp';");
		 	    out.println("</script>");
		 	    out.println("</head><body></body></html>");
			}
			else if (notifs.size() != 0) { //Item has already been requested
				response.setContentType("text/html");
		 	    PrintWriter out = response.getWriter();
		 	    
				String someMessage = "Listing already requested";
		 	    out.println("<script type='text/javascript'>");
		 	    out.println("alert(" + "'" + someMessage + "'" + ");");
		 	    out.println("location='Request.jsp';");
		 	    out.println("</script>");
		 	    out.println("</head><body></body></html>");
			}
			else {	//Item Found and not yet requested
		        
		        User donor = post.getUser();		//Get the user that donated the Item
		        String donorName = donor.getFirstName() + " " + donor.getLastName();
		        String donorEmail = donor.getEmail();
		        String postingID = Integer.toString(post.getId());
		        
				String message = "Hello, I would like to request this Item";
				Notification notify = new Notification(message, donor, asker, post, post);
				UtilDB.insertNotify(notify);	//Save the Notification
				
				response.setContentType("text/html");
	 	        PrintWriter out = response.getWriter();
	 	        String title = " Request Notification";
	    		request.getRequestDispatcher("/Header.jsp").include(request, response);
	    		request.getRequestDispatcher("/Navbar_LoggedIn.jsp").include(request, response);
	    		
	    		String listingName = post.getName();
	    		String listingQuality = post.getQuality();
	    		String listingDesc = post.getDescription();
	    		String donorRole = donor.getRole().getName();
	    		String donorOrg = donor.getOrganization().getName();
	    		
	    		String askerName = asker.getFirstName() + " " + asker.getLastName();
	    		
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
		              + "<section style=\\\"text-align:center\\\">\r\n"
		              + "<br />"
		              + "<h2 style=\"text-align:center\">Item Requested</h2>"
		        //      + "\r\n Item Requested: " + "<br />"
		              + "<br />"
		              + "\r\n Item ID: " + postingID + "<br />"
		              + "\r\n Item Name: " + listingName + "<br />"
				      + "\r\n Quality: " + listingQuality + "<br />"
					  + "\r\n Description: " + listingDesc + "<br />"
					  + "\r\n From User: " + donorName + "<br />"
					  + "\r\n Role: " + donorRole + "<br />"
					  + "\r\n Organization: " + donorOrg + "<br />"
		              + "<br />"
		              + "\r\n Notification Message: " + message + "<br />"
		              + "\r\n From User: " + askerName + "<br />"    
		              + "\r\n To User: " + donorName + "<br />"    
		              + "<br />"
		              + "\r\n Contact " + donorName + "<br />"
		              + "\r\n at " + donorEmail + " to complete the Transaction.<br />"
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
	    		request.getRequestDispatcher("/Footer.jsp").include(request, response);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
