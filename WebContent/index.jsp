<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="parts/head.jsp" >
   		<jsp:param name="title" value="Index"/>
	</jsp:include>
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
					<a href="categories">Categorías.</a>
				</p>
				<p>
					<a href="./create.jsp">Crear</a>
				</p>
			</nav>
	<footer>
		CONTACTO
	</footer>

</body>

</html>