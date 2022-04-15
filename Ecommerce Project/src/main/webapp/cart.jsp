<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="ecommerce.project.model.*"%>
<%@page import="java.util.*"%>
<%@page import="ecommerce.project.dao.ProductDao"%>
<%@page import="ecommerce.project.servlet.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout Cart</title>
<%@include file="includes/head.jsp"%>
<style type="text/css">
.btn-incre, .btn-decre{
font-size: 18px;
}
</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $ ${  (total > 0)? total:0}</h3>
			<a class="mx-3 btn-primary" href="">Check Out</a>
		</div>
		<table class="table table-loght">
			<thead style="font-weight:bold">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th scope="col">Price</th>
					<th scope="col">&nbsp; &nbsp; &emsp; &nbsp; Quantity</th>
			</thead>
			<tbody>
			<% if (cart_list != null) {
				for (Cart c : cartProduct) {%>
					<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getRating()%></td>
					<td><%=c.getPrice()%></td>
					<td>
						<form action="" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
							<div class="form-group d-flex" style="min-width:100px; max-width:200px">
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"> <i
									class="fas fa-minus-square"></i>
								</a> <input type="text" name="quantity" class="form-control" style="text-align:center "
									value="<%= c.getQuantity() %>" readonly> <a class="btn btn-sm btn-incre"
									href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"> <i class="fas fa-plus-square"></i>
								</a>

							</div>

						</form>
					</td>
					<td><a class="btn btn-btn-sm btn-danger" href="">Remove
							From Cart</a></td>
				</tr>
					
				<% }
			}
				
				
				%>
			
				
			</tbody>
		</table>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>