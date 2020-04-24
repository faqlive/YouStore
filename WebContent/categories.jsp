<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${!access}">
	<c:set var="prevpage" scope="session" value="categories"/>
	<c:redirect url = "./login.html"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="parts/head.jsp" >
   		<jsp:param name="title" value="Categorías"/>
	</jsp:include>
</head>
<body>
	<div class="container">
	<main>
		<h3>
			<center>bienvenido:${user.name}</center>
		</h3>
		<a href="#">si quiere ver sus facturas pulse aqui</a><br/>
		<a href="logout">logout</a><br/>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID CATEGORIA</th>
					<th scope="col">DESCRIPCION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${listCategories}" varStatus="loop">
					<tr>
						<th scope="row">${loop.index+1}</th>
						<td>${category.idCat}</td>
						<td><a href="products?idCat=${category.idCat}&nameCat=${category.nameCat}">${category.nameCat}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<footer>
		<a href="carrito.jsp">ver carrito</a>(${total_productos})
	</footer>
	</div>
</body>
</html>