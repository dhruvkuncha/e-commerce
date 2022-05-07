<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="ecommerce.project.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ecommerce.project.dao.ProductDao"%>
<%@ page import="java.util.ArrayList"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
String name = auth.getFirstname();
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
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="main-content">

		<!-- Header -->
		<div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center"
			style="min-height: 600px; background-image: url(https://pbs.twimg.com/media/FHDmNICXIAAzPf7.jpg:large); background-size: cover; background-position: center top;">
			<!-- Mask -->
			<span class="mask bg-gradient-default opacity-8"></span>
			<!-- Header container -->
			<div class="container-fluid d-flex align-items-center">
				<div class="row">
					<div class="col-lg-7 col-md-10">
						<h1 class="display-2 text-white">Hello <%=name%>,</h1>
						<p class="text-white mt-0 mb-5">This is the product space. You
							can shop for products here, look up at prices and product ratings, add your favorites to cart!</p>

					</div>
				</div>
			</div>
		</div>
		<!-- Page content -->
		<div class="container-fluid mt--7">
			<div class="row">
				<div class="card bg-secondary shadow">
					<div class="card-header bg-white border-0">
						<div class="row align-items-center">
							<div class="col-8">
								<h3 class="mb-0"></h3>
							</div>
							<div class="row d-flex justify-content-center ">
								<%
								if (!products.isEmpty()) {
									for (Product p : products) {
								%>
								<div
									class='col-lg-3 col-md-6 mb-5 d-flex justify-content-center mx-2 shadow'>
									<div class="card mw-100"
										style="width: 18rem; border: transparent">
										<img class="card-img-top embed-responsive-item"
											style="object-fit: contain; max-height: 20vh;"
											src="<%=p.getImage()%>" alt="Card image cap">
										<div class="card-body d-flex flex-column">
											<h5 class="card-title"><%=p.getName()%></h5>
											<h6 class="price"><%="$" + p.getPrice()%></h6>
											<h6 class="rating"><%=p.getRating()%></h6>
											<div class="mt-auto d-flex justify-content-between">
												<a href="add-to-cart?id=<%=p.getId()%>" class="btn btn-dark">Add
													to Cart</a> <a href="buy-now?quantity=1&id=<%=p.getId()%>"
													class="btn btn-primary">Buy Now</a>
											</div>

										</div>
									</div>
								</div>

								<%
								}
								}
								%>

							</div>
						</div>
					</div>
				</div>






<div class="footer-basic">
        <footer>
            <div class="social"><a href="#"><i class="fa-brands fa-instagram"></i></a><a href="#"><i class="fa-brands fa-snapchat"></i></a><a href="#"><i class="fa-brands fa-twitter"></i></a><a href="#"><i class="fa-brands fa-facebook-f"></i></a></div>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Home</a></li>
                <li class="list-inline-item"><a href="#">Services</a></li>
                <li class="list-inline-item"><a href="#">About</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <p class="copyright">Ecommerce Project © 2022</p>
        </footer>
    </div>
    

<%@include file="includes/footer.jsp"%>
</body>
</html>