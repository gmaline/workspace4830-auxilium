

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;



/**
 * Servlet implementation class Listings
 */
@WebServlet("/Listings")
public class ListingsIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListingsIndex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.addHeader("Access-Control-Allow-Origin", getServletInfo());
		PrintWriter out = response.getWriter();
		
		JsonObject listing1 = new JsonObject();
		listing1.addProperty("id", "1");
		listing1.addProperty("name", "Markers");
		listing1.addProperty("description", "A bunch of Crayola markers. These are great markers. Really good. The best markers, some might say. People say, I don't say that, people say they're the best markers they've ever used");
		
		JsonObject listing2 = new JsonObject();
		listing2.addProperty("id", "2");
		listing2.addProperty("name", "Calculus Textbook");
		listing2.addProperty("description", "Textbook from a class I don't need anymore.");
		
		JsonObject listing3 = new JsonObject();
		listing3.addProperty("id", "3");
		listing3.addProperty("name", "Notebook");
		listing3.addProperty("description", "Black college-ruled notebook. Great condition.");
		
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.add("listing1", listing1);
		jsonResponse.add("listing2", listing2);
		jsonResponse.add("listing3", listing3);
		
		out.print(jsonResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
