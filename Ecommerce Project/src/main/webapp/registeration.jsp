<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Signup Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<div class="container h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-lg-12 col-xl-11">
				<div class="card text-black" style="border-radius: 25px;">
					<div
						class="card-header text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register
						Account</div>
					<div class="card-body p-md-5 row justify-content-center">
						<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
						<div
								class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
									class="img-fluid" alt="Sample image">

							</div>
							<form action="register" method="post" class="mx-1 mx-md-4">

								<div class="form-group d-flex flex-row align-items-center mb-4">
									<i class="fas fa-user fa-lg me-3 fa-fw"></i>
									<div class="form-outline flex-fill mb-0">
										<input type="text" class="form-control" name="firstname"
											placeholder="Enter Your First Name" required>
									</div>
								</div>
								
								<div class="form-group d-flex flex-row align-items-center mb-4">
									<i class="fas fa-user fa-lg me-3 fa-fw"></i>
									<div class="form-outline flex-fill mb-0">
										<input type="text" class="form-control" name="lastname"
											placeholder="Enter Your Last Name" required>
									</div>
								</div>
								

								<div class="form-group d-flex flex-row align-items-center mb-4">
									<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
									<div class="form-outline flex-fill mb-0">
										<input type="email" class="form-control" name="email"
											placeholder="Enter Your Email" required>
									</div>
								</div>

								<div class="form-group d-flex flex-row align-items-center mb-4">
									<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
									<div class="form-outline flex-fill mb-0">
										<input type="password" class="form-control" name="password"
											placeholder="Enter Your Password" required>
									</div>
								</div>
								<div class="form-group d-flex flex-row align-items-center mb-4">
									<i class="fas fa-key fa-lg me-3 fa-fw"></i>
									<div class="form-outline flex-fill mb-0">
										<input type="password" class="form-control" name=""
											placeholder="Repeat Your Password" required>
									</div>
								</div>
								<div class="form-check d-flex justify-content-center mb-5">
									<input class="form-check-input me-2" type="checkbox" value=""
										id="form2Example3c" required/> <label class="form-check-label"
										for="form2Example3"> I agree all statements in <a
										href="#!">Terms of service</a>
									</label>
								</div>


								<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
									<button type="submit" class="btn btn-primary btn-lg">Register</button>
								</div>
							</form>
							
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</html>

