package ecommerce.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.project.model.*;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/add-to-cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			ArrayList<Cart> cartList= new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			Cart c = new Cart();
			c.setId(id);
			c.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(c);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("index.jsp");
			}
			else {
				cartList = cart_list;
				boolean exist = false;
				
				
				for(Cart ci:cartList) {
					if(ci.getId() == id) {
						exist = true;
						out.println("<h3 style='color:crimson; text-align:center'>Item already exists in cart.<a href='cart.jsp'>Go to Cart</a></h3>");
					}
					
				}
				if(!exist) {
					cartList.add(c);
					response.sendRedirect("index.jsp");
					
				}
			}
		
		}
	}

}
