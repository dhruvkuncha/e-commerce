<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="ecommerce.project.model.*" %>
    
    <%
    User auth = (User) request.getSession().getAttribute("auth");
    if(auth != null){
    	response.sendRedirect("index.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
<div class="card w-50 mx-auto my-5">
<div class="card-header text-center">User Login</div>
<div class="card-body">
<form action="User-Login" method="post">


<div class="form-group">
<label>Email Address</label>
<input type="email" class="form-control" name="login-email" placeholder="Enter Your Email" required>
</div>

<div class="form-group">
<label>Password</label>
<input type="password" class="form-control" name="login-password" placeholder="Enter Your Password" required>
</div>

<div class="text-center">
<button type="submit" class="btn btn-primary">Login</button>
</div>


</form>
</div>

</div>

</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>