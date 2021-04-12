

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

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
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		int[] keys = {1, 2, 3};
		
		//Once I actually implement the back-end, this method will query the database for these values.
		//For now, I'm just making some objects manually to look up. It's very gross and digusting and I feel bad about it.
		JsonObject listing1 = new JsonObject();
		listing1.addProperty("id", "1");
		listing1.addProperty("name", "Markers");
		listing1.addProperty("quality", "Like-New");
		listing1.addProperty("description", "A bunch of Crayola markers. These are great markers. Really good. The best markers, some might say. People say, I don't say that, people say they're the best markers they've ever used");
		listing1.addProperty("user", "User2021");
		
		JsonObject listing2 = new JsonObject();
		listing2.addProperty("id", "2");
		listing2.addProperty("name", "Calculus Textbook");
		listing2.addProperty("quality", "Moderately-Used");
		listing2.addProperty("description", "Textbook from a class I don't need anymore.");
		listing2.addProperty("user", "user9999");
		
		JsonObject listing3 = new JsonObject();
		listing3.addProperty("id", "3");
		listing3.addProperty("name", "Notebook");
		listing3.addProperty("quality", "Like-New");
		listing3.addProperty("description", "Black college-ruled notebook. Great condition.");
		listing3.addProperty("user", "user420blazeit");
		
		String responseName = "";
		String responseQuality = "";
		String responseDesc = "";
		String responseUser = "";
		
		JsonObject[] fakeDatabase = {listing1, listing2, listing3};
		
		
		//Query database for ID (Not implemented yet)
		
		for (int i = 0; i < keys.length; i++) {
			if (id == keys[i]) {
				responseName = fakeDatabase[i].get("name").getAsString();
				responseQuality = fakeDatabase[i].get("quality").getAsString();
				responseDesc = fakeDatabase[i].get("description").getAsString();
				responseUser = fakeDatabase[i].get("user").getAsString();
				break;
			}
		}
		
		//Send data back
		
		
		
		StringBuilder htmlResponse = new StringBuilder();
		
		htmlResponse.append("<!DOCTYPE html>");
		htmlResponse.append("<html>");
		htmlResponse.append("<meta charset=\"ISO-8859-1\">");
		htmlResponse.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
		htmlResponse.append("<title>View Listings</title>\r\n");
		htmlResponse.append("</head>");
		htmlResponse.append("<body>");
		htmlResponse.append("	<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">");
		htmlResponse.append("	    <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\">");
		htmlResponse.append("	        <ul class=\"navbar-nav mr-auto\">");
		htmlResponse.append("	            <li class=\"nav-item\">");
		htmlResponse.append("	                <a class=\"nav-link\" href=\"/webproject/Donation.html\">Donations</a>");
		htmlResponse.append("	            </li>");
		htmlResponse.append("	            <li class=\"nav-item\">");
		htmlResponse.append("	                <a class=\"nav-link\" href=\"#\">Search</a>");
		htmlResponse.append("	            </li>");
		htmlResponse.append("	        </ul>");
		htmlResponse.append("	    </div>");
		htmlResponse.append("	    <div class=\"mx-auto order-0\">");
		htmlResponse.append("	        <a class=\"navbar-brand mx-auto\" href=\"/webproject/HomePage.html\">Auxilium</a>");
		htmlResponse.append("	        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".dual-collapse2\">");
		htmlResponse.append("	            <span class=\"navbar-toggler-icon\"></span>");
		htmlResponse.append("	        </button>");
		htmlResponse.append("	    </div>");
		htmlResponse.append("	    <div class=\"navbar-collapse collapse w-100 order-3 dual-collapse2\">");
		htmlResponse.append("	        <ul class=\"navbar-nav ml-auto\">");
		htmlResponse.append("	            <li class=\"nav-item\">");
		htmlResponse.append("	                <a class=\"nav-link\" href=\"/webproject/SignIn.html\">Login</a>");
		htmlResponse.append("	            </li>");
		htmlResponse.append("	            <li class=\"nav-item\">");
		htmlResponse.append("	                <a class=\"nav-link\" href=\"#\">Register</a>");
		htmlResponse.append("	            </li>");
		htmlResponse.append("	        </ul>");
		htmlResponse.append("	    </div>");
		htmlResponse.append("	</nav>");
		htmlResponse.append("	<br><br><br>");
		htmlResponse.append("	<div class=\"text-center col-4 offset-4\">");
		htmlResponse.append("		<h4>" + responseName + "</h4>");
		htmlResponse.append("		<br><br>");
		htmlResponse.append("		<p><strong>Quality:</strong> "+ responseQuality +"</p>");
		htmlResponse.append("		<br><br>");
		htmlResponse.append("		<p><strong>Description:</strong> " + responseDesc +"</p>");
		htmlResponse.append("		<br><br>");
		htmlResponse.append("		<p><strong>Posted by:</strong> " + responseUser + "</p>");
		htmlResponse.append("		<br><br>");
		htmlResponse.append("		<button type=\"button\" class=\"btn btn-primary\">Request this item</button>");
		htmlResponse.append("	</div>");
		htmlResponse.append("	<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
		htmlResponse.append("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>");
		htmlResponse.append("	<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>");
		htmlResponse.append("</body>");
		htmlResponse.append("</html>");
		
		
		String responseData = htmlResponse.toString();
		
		out.print(responseData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
