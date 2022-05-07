package ecommerce.project.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.project.connection.DbCon;
import ecommerce.project.model.*;
import ecommerce.project.model.User;
import ecommerce.project.dao.*;


@WebServlet("/cart-check-out")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
			Date date = new Date();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			User auth = (User) request.getSession().getAttribute("auth");
			String address = request.getParameter("add");
			String add1 = request.getParameter("address");
			String add2 = request.getParameter("city");
			String add3 = request.getParameter("state");
			String add4 = request.getParameter("zip");
			String cNo = request.getParameter("mode");
			String c1 = request.getParameter("cardnumber");
			String c2 = request.getParameter("cardname");
			String c3 = (String) request.getParameter("expmonth");
			String c4 = request.getParameter("expyear");
			String c5 = request.getParameter("cvv");
			Double c6 = 0.0;
			User userModel1 = new User(auth.getId(), add1, add2, add3, add4);
			User userModel2 = new User(auth.getId(), c1, c2, c3, c5, c6);
			
			
			
			
			if(cart_list != null && auth != null) {
				OrderDao od = new OrderDao(DbCon.getConnection());
				UserDao ud = new UserDao(DbCon.getConnection());
				
				if(address.equals("Add New") && ud.addressInsert(userModel1)) {
					address = add1;
				}
				User u = od.getAddress(address);
				
				if(cNo.equals("Add New") && ud.cardInsert(userModel2)) {
					cNo = c1;
				}
				
				User a = od.getCard(Integer.parseInt(cNo));
				
				
				
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setaId(u.getaId());
					order.setcId(a.getcId());
					order.setDate(formatter.format(date));
					
					
					OrderDao o_dao = new OrderDao(DbCon.getConnection());
					boolean result = o_dao.insertOrder(order);
					if(!result) {
						break;
					}
				
	
				//}
				cart_list.clear();
				response.sendRedirect("orders.jsp");
				}
				//else {
				//	request.getSession().setAttribute("e", "notexist");
				//}
			}
			else{
				if(auth == null) response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
