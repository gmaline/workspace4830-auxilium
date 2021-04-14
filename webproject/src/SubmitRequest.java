

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		try {
			int item = ((Number)NumberFormat.getInstance().parse(id)).intValue(); //gets the integer value from the String
			
			Posting post = new Posting();
			post = UtilDB.FindListing(item);
			
			//System.out.println(post.toString());
		
			if(post != null) {		//Item Found
				 
				
				
			}
			else {	//Item Not Found
  				 response.setContentType("text/html");
		 	     PrintWriter out = response.getWriter();
		 	     
		 	     String someMessage = "ITEM NOT FOUND!\\nDouble Check Item Number";
		 	     out.println("<script type='text/javascript'>");
		 	     out.println("alert(" + "'" + someMessage + "'" + ");");
		 	     out.println("location='Request.jsp';");
		 	     out.println("</script>");
		 	     out.println("</head><body></body></html>");
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
