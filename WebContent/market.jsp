<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "j" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<center>bienvenido:${user}</center>
	</h3>
	<a href="S_VerFacturas">si quiere ver sus facturas pulse aqui</a>
	<BR>
	<a href="S_Logout">logout</a>
	<BR>
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
	<a href="carrito.jsp">ver carrito</a>(${total_productos})
</body>
</html>