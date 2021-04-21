

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import datamodel.Posting;
import util.UtilDB;

/**
 * Servlet implementation class Listing
 */
@WebServlet("/Listing")
public class Listing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");		
		int id = Integer.valueOf(request.getParameter("id"));	
				
		Posting post = UtilDB.FindListing(id);

		String name = "";
		String quality = "";
		String description = "";
		String user = "";

		// Check if it was actually found

		if (post.getId() != null) {
			name = post.getName();
			quality = post.getQuality();
			description = post.getDescription();
			user = post.getUser().getFirstName() + " " + post.getUser().getLastName();
		}

		
		//Send data back
		
		request.setAttribute("name", name);
		request.setAttribute("quality", quality);
		request.setAttribute("description", description);
		request.setAttribute("user", user);
		request.setAttribute("id", id);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Listing.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
