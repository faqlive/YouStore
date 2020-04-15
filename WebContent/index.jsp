<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<nav>

			<c:if test="${access}">
			<p><c:out value="${access}"/>A</p>
			<p>${access} B</p>
			<p>
				<a href="logout">LogOut</a>
			</p>
			</c:if>
			<c:if test="${!access}">
			<p>
				<a href="http://localhost:8080/youstore/signin.html">Signin</a>
			</p>
			<p>
				<a href="http://localhost:8080/youstore/login.html">LogIn</a>
			</p>
			</c:if>
			<p>
				<a href="http://localhost:8080/youstore/index.jsp">OTRO link</a>
			</p>
		</nav>
		<main>
			<h3>${mensaje}</h3>
		</main>	
	</div>
</body>
</html>