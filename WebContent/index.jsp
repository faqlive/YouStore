<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Idex JSP</title>
</head>
<body>
<%@ page import = "java.util.Date,model.User" %>
<% Date fecha = new Date(); %>

<h1>INDEX</h1>
	<div class="container">
	<center><h2>MADRID A  <%=fecha.toString() %>   </h2></center>
		<p>
			<a href="http://localhost:8080/youstore/signin.html">Signin</a>
		</p>
		<p>
			<a href="http://localhost:8080/youstore/login.html">LogIn</a>
		</p>
		<p>
			<a href="http://localhost:8080/youstore/index.html">OTRO link</a>
		</p>
	</div>
</body>
</html>