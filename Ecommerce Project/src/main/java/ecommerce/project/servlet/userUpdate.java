package ecommerce.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.project.connection.DbCon;
import ecommerce.project.dao.UserDao;
import ecommerce.project.model.User;

/**
 * Servlet implementation class userUpdate
 */
@WebServlet("/user-update")
public class userUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("_email");
		String password = request.getParameter("_password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		User userModel = new User(firstname, lastname, email, password);
	

		// create a database model
		UserDao regUser;
		
		try {
			regUser = new UserDao(DbCon.getConnection());
			String action = request.getParameter("userUpd");
			if (action.equals("Update") && regUser.userUpdate(userModel, email)) {
				response.sendRedirect("account.jsp");
			

			}
			if(action.equals("Delete") && regUser.userDelete(email)) {
				if(request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login.jsp");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

}
