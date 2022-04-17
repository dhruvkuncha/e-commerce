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

	
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//make user object
		User userModel = new User(name, email, password);

		//create a database model
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
