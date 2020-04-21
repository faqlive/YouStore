<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="refresh" content="180">
	<meta name="description" content="Profecional information">
	<meta name="keywords" content="Java Developer, Backend, Oracle">
	<meta name="author" content="Facundo J. Lopez">
	<meta charset="UTF-8">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="./static/css/style.css">
	<title>Home YouStore</title>
</head>

<body>
	<c:set var="now" scope="page" value="<%=new java.util.Date()%>" />
	
	 
	<header>
		<h1>INDEX</h1>
			<h2>MADRID A  <fmt:formatDate value="${now}" type="date" />
	 		<fmt:formatDate value="${now}" type="time" /> </h2>
	</header>
	<main>
		<div class="container">
			<article>
				<h3>${mensaje}</h3>
			</article>
		</div>
	</main>
	<nav>
				<c:if test="${access}">
					<p>
						<a href="logout">LogOut</a>
					</p>
				</c:if>
				<c:if test="${!access}">
					<p>
						<a href="./signin.html">Signin</a>
					</p>
					<p>
						<a href="./login.html">LogIn</a>
					</p>
				</c:if>
				<p>
					<a href="categories">Página Segura.</a>
				</p>
			</nav>
	<footer>
		CONTACTO
	</footer>

</body>

</html>