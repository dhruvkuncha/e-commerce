package ecommerce.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.project.connection.DbCon;
import ecommerce.project.dao.UserDao;
import ecommerce.project.model.User;


@WebServlet("/address")
public class address extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User auth = (User) request.getSession().getAttribute("auth");
		int id = auth.getId();

		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		
		

		User userModel = new User(id, address, city, state, zip);

		UserDao ud;
		//String cId = request.getParameter("add");

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			try {
				ud = new UserDao(DbCon.getConnection());
				String action = request.getParameter("add");

				if (action.equals("Add New") && ud.addressInsert(userModel)) {

					String message = "Added Card";
					request.setAttribute("message", message);
					response.sendRedirect("account.jsp");
				}
				if (!action.equals("Add New") && ud.addressUpdate(userModel, action)) {

					response.sendRedirect("account.jsp");
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

}
