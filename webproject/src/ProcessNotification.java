

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Notification;
import datamodel.Posting;
import util.UtilDB;

/**
 * Servlet implementation class ProcessNotification
 */
@WebServlet("/ProcessNotification")
public class ProcessNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notificationResponse = request.getParameter("notificationResponse");
		String notificationId = request.getParameter("notificationId");
		
		if (notificationResponse.equals("accept")) {
			Notification notif = UtilDB.getNotificationById(Integer.valueOf(notificationId));
			Posting post = notif.getDonation();
			
			UtilDB.removeNotification(notif);
			UtilDB.removePosting(post);
		}
		else if (notificationResponse.equals("deny")) {
			Notification notif = UtilDB.getNotificationById(Integer.valueOf(notificationId));
			UtilDB.removeNotification(notif);
		}
		else {
			response.getWriter().write("unknown error occured");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
