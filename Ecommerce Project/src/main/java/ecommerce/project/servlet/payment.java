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

@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * int id = Integer.parseInt(request.getParameter("id")); int cId =
		 * Integer.parseInt(request.getParameter("cId")); String cNo =
		 * request.getParameter("cNo"); String validThrough =
		 * request.getParameter("validThrough"); String cvv =
		 * request.getParameter("cvv"); double creditBalance =
		 * Double.parseDouble(request.getParameter("creditBalance"));
		 * 
		 * User userModel = new User(id, cId, cNo, validThrough, cvv, creditBalance);
		 * 
		 * UserDao ud; try { ud = new UserDao(DbCon.getConnection()); if
		 * (ud.getAllCards(userModel.getId()) == null) {
		 * response.sendRedirect("account.jsp"); } else { String errorMessage =
		 * "User Available"; HttpSession regSession = request.getSession();
		 * regSession.setAttribute("RegError", errorMessage);
		 * response.getWriter().print(errorMessage);
		 * response.sendRedirect("registeration.jsp"); } } catch (ClassNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * }
		 */
		User auth = (User) request.getSession().getAttribute("auth");
		int id = auth.getId();

		String cNo = request.getParameter("cNo");
		String cName = request.getParameter("cName");
		String validThrough = request.getParameter("validThrough");
		String cvv = request.getParameter("cvv");
		double creditBalance = Double.parseDouble(request.getParameter("creditBalance"));

		User userModel = new User(id, cNo, cName, validThrough, cvv, creditBalance);

		UserDao ud;
		//String cId = request.getParameter("card");

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			try {
				ud = new UserDao(DbCon.getConnection());
				String action = request.getParameter("card");

				if (action.equals("Add New") && ud.cardInsert(userModel)) {

					String message = "Added Card";
					request.setAttribute("message", message);
					response.sendRedirect("account.jsp");
				}
				if (!action.equals("Add New") && ud.cardUpdate(userModel, action)) {
					System.out.println(action);

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
