<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="ecommerce.project.model.*"%>
<%@page import="java.util.*"%>
<%@page import="ecommerce.project.dao.*"%>
<%@page import="ecommerce.project.servlet.*"%>
<%@page import="java.text.DecimalFormat"%>

<%
DecimalFormat df = new DecimalFormat("#.##");
request.setAttribute("df", df);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
UserDao udao = new UserDao(DbCon.getConnection());
List<User> add = udao.getAllAddress(auth.getId());
List<User> cards = udao.getAllCards(auth.getId());
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
<link rel="stylesheet" type="text/css" href="css/cart.css" />

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $ ${  (total > 0)? df.format(total):0}</h3>

		</div>
		<table class="table table-loght">
			<thead style="font-weight: bold">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th scope="col">Price</th>
					<th scope="col">&nbsp; &nbsp; &emsp; &nbsp; Quantity</th>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getRating()%></td>
					<td><%=df.format(c.getPrice())%></td>
					<td>
						<form action="buy-now" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%=c.getId()%>"
								class="form-input">
							<div class="form-group d-flex"
								style="min-width: 100px; max-width: 200px">
								<a class="btn-sm btn-decre"
									href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"> <i
									class="fas fa-minus-square"></i>
								</a> <input type="text" name="quantity" class="form-control"
									style="text-align: center" value="<%=c.getQuantity()%>"
									readonly> <a class="btn-sm btn-incre"
									href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"> <i
									class="fas fa-plus-square"></i>
								</a>



							</div>


						</form>
					</td>
					<td><a class="btn btn-btn-sm btn-danger"
						href="remove-from-cart?id=<%=c.getId()%>">Remove From Cart</a></td>
				</tr>

				<%
				}
				}
				%>



			</tbody>
		</table>
		<!--  Address  -->
		<div class="row">
			<div class="col-75">
				<div class="container">
					<form action="cart-check-out">


						<div class="row">
							<div class="col-50">
								<h3>Billing Address</h3>

								<div class="row">
									<div class="col-50 mb-3">
										<label for="add">Select Address</label> <select name="add"
											id="input-address">
											<option name="Add New">Add New</option>
											<%
											for (User a : add) {
											%>


											<option name="existing"><%=a.getAddress()%></option>

											<%
											}
											%>
										</select>
									</div>
								</div>
								<label for="fname"><i class="fa fa-user"></i> Full Name</label>
								<input type="text" id="fname" name="firstname"
									placeholder="John M. Doe"> <label for="email"><i
									class="fa fa-envelope"></i> Email</label> <input type="text" id="email"
									name="email" placeholder="john@example.com"> <label
									for="adr"><i class="fa fa-address-card-o"></i> Address</label>
								<input type="text" id="adr" name="address"
									placeholder="542 W. 15th Street"> <label for="city"><i
									class="fa fa-institution"></i> City</label> <input type="text"
									id="city" name="city" placeholder="New York">



								<div class="row">
									<div class="col-50">
										<label for="state">State</label> <input type="text" id="state"
											name="state" placeholder="NY">
									</div>
									<div class="col-50">
										<label for="zip">Zip</label> <input type="text" id="zip"
											name="zip" placeholder="10001">
									</div>
								</div>
							</div>

							<div class="col-50">
								<h3>Payment</h3>
								<label for="fname">Accepted Cards</label>
								<div class="icon-container">
									<i class="fa fa-cc-visa" style="color: navy;"></i> <i
										class="fa fa-cc-amex" style="color: blue;"></i> <i
										class="fa fa-cc-mastercard" style="color: red;"></i> <i
										class="fa fa-cc-discover" style="color: orange;"></i>
								</div>
								<div class="row">
									<div class="col-50 mb-3">
										<label for="mode">Select Card</label> <select name="mode"
											id="input-address">
											<option name="Add New">Add New</option>
											<%
											for (User a : cards) {
											%>


											<option name="existing" value=<%=a.getcNo() %>><%=a.getcName() + "'s card" %></option>

											<%
											}
											%>
										</select>
									</div>
								</div>
								<label for="cname">Name on Card</label> <input type="text"
									id="cname" name="cardname" placeholder="John More Doe">
								<label for="ccnum">Credit card number</label> <input type="text"
									id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
								<label for="expmonth">Valid Through</label> <input type="month"
									id="expmonth" name="expmonth" placeholder="September">

								<div class="row" style="margin-top: 41px">
									
									<div class="col-50">
										<label for="cvv">CVV</label> <input type="text" id="cvv"
											name="cvv" placeholder="352">
									</div>
									<div class="col-50">
										<label for="cbal">Credit Balance</label> <input type="text" id="cbal"
											name="cbal" placeholder="$99.9">
									</div>
								</div>
							</div>

						</div>
						<label> <input type="checkbox" checked="checked"
							name="sameadr"> Shipping address same as billing
						</label> <input type="submit" value="Continue to checkout" class="btn">
					</form>
				</div>
			</div>

			<div class="col-25">
				<div class="container">
					<h4>
						Cart <span class="price" style="color: black"> <i
							class="fa fa-shopping-cart"></i> <b>${cart_list.size()}</b>
						</span>
					</h4>
					<%
					if (cart_list != null) {
						for (Cart c : cartProduct) {
					%>
					<p>
						<a href="#"><%=c.getName()%></a><span class="price"><%=df.format(c.getPrice())%></span>
					</p>

					<hr>
					<%
					}
					}
					%>
					<p>
						Total <span class="price" style="color: black"><b>$ ${  (total > 0)? df.format(total):0}</b></span>
					</p>
					
					
				</div>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>