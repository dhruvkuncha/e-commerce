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

@WebServlet("/register")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String username = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		// make user object
		User userModel = new User(firstname, lastname, email, password);

		// create a database model
		UserDao regUser;
		
		try {
			regUser = new UserDao(DbCon.getConnection());
			if (regUser.userRegister(userModel)) {
				response.sendRedirect("login.jsp");
			

			} else {
				String errorMessage = "User Available";
				HttpSession regSession = request.getSession();
				regSession.setAttribute("RegError", errorMessage);
				response.getWriter().print(errorMessage);
				response.sendRedirect("registeration.jsp");
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
