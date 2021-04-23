

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import util.UtilDB;
import datamodel.Notification;
import datamodel.Posting;



/**
 * Servlet implementation class Listings
 */
@WebServlet("/ListingsIndex")
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

		List<Posting> posts = UtilDB.listPostings();
		
		for (int i = posts.size() - 1; i >= 0 ; i--) {
			List<Notification> notifs = UtilDB.getNotificationsByPost(posts.get(i));
			if (notifs.size() > 0) {
				posts.remove(i);
			}
		}
				
		request.setAttribute("posts", posts);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListingsIndex.jsp");
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
