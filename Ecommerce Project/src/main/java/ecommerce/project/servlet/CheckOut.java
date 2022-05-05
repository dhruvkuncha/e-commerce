package ecommerce.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
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
			String address = (String) request.getParameter("address");
			String city = (String) request.getParameter("city");
			String state = (String) request.getParameter("state");
			String zip = (String) request.getParameter("zip");
			
			if(cart_list != null && auth != null) {
				
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setAddress(address);
					order.setCity(city);
					order.setState(state);
					order.setZip(zip);
					order.setDate(formatter.format(date));
					
					OrderDao o_dao = new OrderDao(DbCon.getConnection());
					boolean result = o_dao.insertOrder(order);
					if(!result) {
						break;
					}
	
				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");
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
