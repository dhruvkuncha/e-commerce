<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Register Account</div>
			<div class="card-body">
				<form action="register" method="post">

					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="name" placeholder="Enter Your Name" required>
					</div>

					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name="email" placeholder="Enter Your Email"
							required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Enter Your Password" required>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Sign Up</button>
					</div>


				</form>
			</div>

		</div>

	</div>
</html>

