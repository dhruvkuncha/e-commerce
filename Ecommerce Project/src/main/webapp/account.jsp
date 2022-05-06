<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ecommerce.project.connection.DbCon"%>
<%@page import="ecommerce.project.model.*"%>
<%@page import="java.util.List"%>
<%@page import="ecommerce.project.dao.*"%>
<%@ page import="java.util.ArrayList"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
String name = auth.getFirstname();
String email = auth.getEmail();
String address = auth.getAddress();
String state = auth.getState();
String city = auth.getCity();
String zip = auth.getZip();
String msg = "";
UserDao udao = new UserDao(DbCon.getConnection());
List<User> cards = udao.getAllCards(auth.getId());
List<User> add = udao.getAllAddress(auth.getId());
//User m = add.get(0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/head.jsp"%>
<link rel="stylesheet" type="text/css" href="css/account.css" />
</head>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">



<body>
	<div class="main-content">
		<!-- Top navbar -->
		<nav class="navbar navbar-top navbar-expand-md navbar-dark"
			id="navbar-main">
			<div class="container-fluid">
				<!-- Brand -->
				<a
					class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block"
					href="index.jsp" target="_blank">Ecommerce Project</a>
				<!-- Form -->

				<!-- User -->
				<ul class="navbar-nav align-items-center d-none d-md-flex">
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
								<span class="avatar avatar-sm rounded-circle"> <img
									alt="Image placeholder"
									src="https://demos.creative-tim.com/argon-dashboard/assets-old/img/theme/team-4.jpg">
								</span>
								<div class="media-body ml-2 d-none d-lg-block">
									<span class="mb-0 text-sm  font-weight-bold"><%=name%></span>
								</div>
							</div>
					</a>
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="cart.jsp" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
							
								<div class="media-body ml-2 d-none d-lg-block">
								
									<span class="mb-0 text-sm  font-weight-bold">Cart<span class="badge bg-danger">${cart_list.size()}</span></span>
								</div>
							</div>
					</a>
					
					</li>
					
					</li>
					
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="index.jsp" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
							
								<div class="media-body ml-2 d-none d-lg-block">
								
									<span class="mb-0 text-sm  font-weight-bold">Home</span>
								</div>
							</div>
					</a>
					
					</li>
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="orders.jsp" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
							
								<div class="media-body ml-2 d-none d-lg-block">
								
									<span class="mb-0 text-sm  font-weight-bold">Orders</span>
								</div>
							</div>
					</a>
					
					</li>
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="log-out" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
							
								<div class="media-body ml-2 d-none d-lg-block">
								
									<span class="mb-0 text-sm  font-weight-bold">Logout</span>
								</div>
							</div>
					</a>
					
					</li>
				</ul>
			</div>
		</nav>
		<!-- Header -->
		<div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center"
			style="min-height: 600px; background-image: url(https://raw.githubusercontent.com/creativetimofficial/argon-dashboard/gh-pages/assets-old/img/theme/profile-cover.jpg); background-size: cover; background-position: center top;">
			<!-- Mask -->
			<span class="mask bg-gradient-default opacity-8"></span>
			<!-- Header container -->
			<div class="container-fluid d-flex align-items-center">
				<div class="row">
					<div class="col-lg-7 col-md-10">
						<h1 class="display-2 text-white">
							Hello
							<%=name%></h1>
						<p class="text-white mt-0 mb-5">This is your profile page. You
							can see the progress you've made with your work and manage your
							projects or assigned tasks</p>

					</div>
				</div>
			</div>
		</div>
		<!-- Page content -->
		<div class="container-fluid mt--7">
			<div class="row">
				<div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
					<div class="card card-profile shadow">
						<div class="row justify-content-center">
							<div class="col-lg-3 order-lg-2">
								<div class="card-profile-image">
									<a href="#"> <img
										src="https://demos.creative-tim.com/argon-dashboard/assets-old/img/theme/team-4.jpg"
										class="rounded-circle">
									</a>
								</div>
							</div>
						</div>
						<div
							class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
							<div class="d-flex justify-content-between"></div>
						</div>
						<div class="card-body pt-0 pt-md-4">
							<div class="row">
								<div class="col">
									<div
										class="card-profile-stats d-flex justify-content-center mt-md-5">
										<div>
											<a href="account.jsp"><span class="heading"><i
													class="fa fa-user"></i></span> <span class="description">Profile</span></a>
										</div>
										<div>
											<a href="orders.jsp"><span class="heading"><i
													class="fa fa-shopping-bag" aria-hidden="true"></i></span> <span
												class="description">My orders</span></a>
										</div>
										<div>
											<a href="index.jsp"><span class="heading"><i
													class="fa fa-home" aria-hidden="true"></i></span> <span
												class="description">Home</span></a>
										</div>
									</div>
								</div>
							</div>
							<div class="text-center">

								<div class="h5 font-weight-300">
									<i class="ni location_pin mr-2"></i>
								</div>
								<div class="h5 mt-4"></div>
								<div></div>
								<hr class="my-4">

							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-8 order-xl-1">
					<div class="card bg-secondary shadow">
						<div class="card-header bg-white border-0">
							<div class="row align-items-center">
								<div class="col-8">
									<h3 class="mb-0">My account</h3>
								</div>
								<div class="col-4 text-right"></div>
							</div>
						</div>
						<div class="card-body">
							<form action="user-update" method="post">
								<h6 class="heading-small text-muted mb-4">User information</h6>
								<div class="pl-lg-4">
									<div class="row">
										<div class="col-md-12">
											<label for="userUpd" class="form-control-label">Choose
												an option:</label> <select name="userUpd" id="input-address">
												<option name="new">Update</option>
												<option name="del">Delete</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group focused">

									<div class="row">
										<div class="col-lg-6">
											<div class="form-group focused">

												<label class="form-control-label" for="input-username">Email</label>
												<input type="text" id="input-username" name="email"
													class="form-control form-control-alternative"
													placeholder="Email">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label class="form-control-label" for="input-email">Password
												</label> <input type="password" id="input-email" name="password"
													class="form-control form-control-alternative"
													placeholder="Password">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6">
											<div class="form-group focused">
												<label class="form-control-label" for="input-first-name">First
													name</label> <input type="text" id="input-first-name"
													name="firstname"
													class="form-control form-control-alternative"
													placeholder="First name" >
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group focused">
												<label class="form-control-label" for="input-last-name">Last
													name</label> <input type="text" id="input-last-name"
													name="lastname"
													class="form-control form-control-alternative"
													placeholder="Last name">
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-center">
										<input type="submit" class="btn btn-info" value="Edit profile">
									</div>
								</div>
								<hr class="my-4">
							</form>
							<!-- Address -->
							<form action="address" method="post">
								<h6 class="heading-small text-muted mb-4">Contact
									information</h6>
								<div class="pl-lg-4">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group focused">
												<h3 style='color: green'>${message}</h3>
												<c:remove var="message" scope="session" />



												<label for="card" class="form-control-label">Choose
													an address:</label> <select name="add" id="input-address">
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
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group focused">
												<label class="form-control-label" for="input-address">Address</label>
												<input id="input-address"
													class="form-control form-control-alternative"
													name="address" placeholder="580 Wiff Oaf Lane" value=""
													type="text">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-4">
											<div class="form-group focused">
												<label class="form-control-label" for="input-city">City</label>
												<input type="text" id="input-city"
													class="form-control form-control-alternative" name="city"
													placeholder="New York" value="">
											</div>
										</div>
										<div class="col-lg-4">
											<div class="form-group focused">
												<label class="form-control-label" for="input-country">State</label>
												<input type="text" id="input-country"
													class="form-control form-control-alternative" name="state"
													placeholder="NY" value="">
											</div>
										</div>
										<div class="col-lg-4">
											<div class="form-group">
												<label class="form-control-label" for="input-country">Postal
													code</label> <input type="text" id="input-postal-code"
													class="form-control form-control-alternative" name="zip"
													placeholder="10001" value="">
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-center">
										<input type="submit" class="btn btn-info" value="Edit profile">
									</div>
								</div>
								<hr class="my-4">
							</form>
							<!-- Credit Card -->
							<form action="payment" method="post">

								<h6 class="heading-small text-muted mb-4">Credit Card
									information</h6>
								<div class="pl-lg-4">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group focused">


												<h3 style='color: green'>${message}</h3>
												<c:remove var="message" scope="session" />



												<label for="card" class="form-control-label">Choose
													a card:</label> <select name="card" id="input-address">
													<option name="new">Add New</option>
													<%
													for (User c : cards) {
													%>


													<option name="existing" value=<%=c.getcNo() %>><%=c.getcName() + "'s card"%></option>

													<%
													}
													%>
												</select>

											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group focused">
												<label class="form-control-label" for="ccnum">Credit
													card number</label> <input id="input-address"
													class="form-control form-control-alternative" type="text"
													id="ccnum" placeholder="1111-2222-3333-4444" name="cNo">

											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12">
											<div class="form-group focused">
												<label class="form-control-label" for="ccnum">Name
													on card</label> <input id="input-address"
													class="form-control form-control-alternative" type="text"
													id="ccnum" placeholder="Jane Doe" name="cName">

											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-lg-4">
											<div class="form-group focused">
												<label class="form-control-label" for="input-city">Valid
													thru</label> <input type="month" id="input-city"
													class="form-control form-control-alternative"
													placeholder="September" value="2022-06" name="validThrough">
											</div>
										</div>
										<div class="col-lg-4">
											<div class="form-group focused">
												<label class="form-control-label" for="input-country">CVV</label>
												<input type="text" id="input-country"
													class="form-control form-control-alternative"
													placeholder="123" name="cvv">
											</div>
										</div>
										<div class="col-lg-4">
											<div class="form-group">
												<label class="form-control-label" for="input-country">Postal
													code</label> <input type="text" id="input-postal-code"
													class="form-control form-control-alternative"
													placeholder="10001" name="creditBalance">
											</div>
										</div>
									</div>
									<div class="d-flex justify-content-center">
										<input type="submit" class="btn btn-info" value="Edit profile">
									</div>
								</div>
								<hr class="my-4">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer"> </footer>
</body>
</html>