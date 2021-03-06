

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Organization;
import datamodel.Posting;
import datamodel.Role;
import datamodel.User;
import util.UtilDB;

/**
 * Servlet implementation class ProcessDonation
 */
@WebServlet("/ProcessDonation")
public class ProcessDonation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessDonation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String quality = request.getParameter("quality");
		String description = request.getParameter("description");
		String currentUser = (String) request.getSession().getAttribute("userEmail");

		if (currentUser.equals(null)) {
			
		}
		List<User> users = UtilDB.listUsers();
		User user = new User();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(currentUser)) {
				user = users.get(i);
				break;
			}
		}
		
		if (user != null) {
			UtilDB.insertPosting(name, quality, description, false, user);
		}
		else {
			request.setAttribute("name", "Something went wrong :( Check the database");
		}

		List<Posting> posts = UtilDB.listPostings();
		for (int i = 0; i < posts.size(); i++) {

			if (posts.get(i).getName().equals(name)) {
				request.setAttribute("name", name);
			}
			else {
				request.setAttribute("name", "Something went wrong :( Check the database");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("ListingsIndex");
		rd.forward(request, response);
	}

}
