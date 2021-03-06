import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Notification;
import datamodel.Posting;
import util.UtilDB;

@WebServlet("/SimpleFormSearch")
public class SimpleFormSearch extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SimpleFormSearch() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	String keyword = request.getParameter("keyword").trim();
	  	response.getWriter().append(keyword);
	   

		
	   List<Posting> posts = UtilDB.FindListing(keyword);
		
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

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
