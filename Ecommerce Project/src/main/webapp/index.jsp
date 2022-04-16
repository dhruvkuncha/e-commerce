<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="ecommerce.project.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ecommerce.project.dao.ProductDao"%>
<%@ page import="java.util.ArrayList" %>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to the online store</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header-my-3">Products</div>
		<div class="row">
		<%
		if(!products.isEmpty()){
			for(Product p : products){ 
		 %>
				<div class='my-3 col-md-6 col-lg-4 d-flex justify-content-center'>
				<div class="card mw-100" style="width: 18rem;">
					<img class="card-img-top embed-responsive-item" style=" object-fit: contain; max-height: 20vh;" src="<%= p.getImage() %>" alt="Card image cap">
					<div class="card-body d-flex flex-column">
						<h5 class="card-title"><%= p.getName() %></h5>
						<h6 class="price"><%="$" + p.getPrice() %></h6>
						<h6 class="rating"><%= p.getRating() %></h6>
						<div class="mt-auto d-flex justify-content-between">
							<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a> 
							<a href="buy-now?quantity=1&id=<%=p.getId() %>"	class="btn btn-primary">Buy Now</a>
						</div>

					</div>
				</div>
			</div>
		<% 	}
		}
		%>
			
		</div>
	</div>




	<%@include file="includes/footer.jsp"%>
</body>
</html>