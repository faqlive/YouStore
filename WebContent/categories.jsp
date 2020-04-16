<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${!access}">
	<c:set var="nextpage" scope="session" value="/categories.jsp"/>
	<c:redirect url = "./login.html"/>
</c:if>
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
<title>Categories YouStore</title>
</head>
<body>
	<main>
		<h3>
			<center>bienvenido:${user.name}</center>
		</h3>
		<a href="S_VerFacturas">si quiere ver sus facturas pulse aqui</a><br/>
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
				<c:forEach var="categoria" items="${categorias}" varStatus="loop">
					<tr>
						<th scope="row">${loop.index+1}</th>
						<td>${categoria.id_categoria}</td>
						<td><a
							href="S_List_Productos?id_categoria=${categoria.id_categoria}&descripcion=${categoria.descripcion}">${categoria.descripcion}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<footer>
		<a href="carrito.jsp">ver carrito</a>(${total_productos})
	</footer>
</body>
</html>