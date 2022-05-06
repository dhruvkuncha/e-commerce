<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@page import="ecommerce.project.model.*"%>
<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="ecommerce.project.dao.*"%>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
List<Order> orders = null;
if (auth != null) {
	request.setAttribute("person", auth);
	OrderDao orderDao = new OrderDao(DbCon.getConnection());
	orders = orderDao.userOrders(auth.getId());
} else {
	response.sendRedirect("login.jsp");
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Orders Page</title>
<%@include file="includes/head.jsp"%>
<%@include file="includes/navbar.jsp"%>
</head>
<body>



	<link rel="stylesheet"
		href="https://allyoucan.cloud/cdn/icofont/1.0.1/icofont.css"
		integrity="sha384-jbCTJB16Q17718YM9U22iJkhuGbS0Gd2LjaWb4YJEZToOPmnKDjySVa323U+W7Fv"
		crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/orders.css" />
	<div class="container">
		<div class="row">

			<div class="col-md-9">
				<div class="osahan-account-page-right shadow-sm bg-white p-4 h-100">
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane  fade  active show" id="orders"
							role="tabpanel" aria-labelledby="orders-tab">
							<h4 class="font-weight-bold mt-0 mb-4">All Orders</h4>
							<%
							if (orders != null) {
								for (Order o : orders) {
							%>
							<div class="bg-white card mb-4 order-list shadow-sm">
								<div class="gold-members p-4">
									<a href="#"> </a>
									<div class="media">

										<div class="media-body">
											<h4 class="float-right text-info">
												Order placed on
												<%=o.getDate()%>
												<i class="icofont-check-circled text-success"></i>
											</h4>

											<h6 class="mb-2">
												<span class="text-black"><%=o.getName()%></span>
											</h6>


											<p class="text-gray mb-3">
												<i class="icofont-list"></i>
												<%=o.getRating()%>

											</p>
											<p class="text-dark"><%=o.getName()%>
												x
												<%=o.getQuantity()%></p>
											<hr>
											<div class="float-right">
												<a class="btn btn-sm btn-outline-primary"
													href="cancel-order?id=<%=o.getOrderId()%>"><i
													class="icofont-headphone-alt"></i> Cancel</a> <a
													class="btn btn-sm btn-primary" href="index.jsp"><i
													class="icofont-refresh"></i> REORDER</a>
											</div>
											<p class="mb-0 text-black text-primary pt-2">
												<span class="text-black font-weight-bold"> Total
													Paid:</span> $
												<%=o.getPrice()%>
											</p>
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
		</div>
	</div>
</body>
</html>