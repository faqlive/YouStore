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
<jsp:include page="parts/head.jsp">
	<jsp:param name="title" value="Productos" />
</jsp:include>
</head>
<body>
<h3><center>bienvenido:${user}
</center></h3>
<a href="logout">logout</a>
<h3><center>${descripcion_categoria}</center></h3>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">ID PRODUCTO</th>
      <th scope="col">DESCRIPCION</th>
      <th scope="col">PRECIO</th>
      <th scope="col">STOCK</th>
      <th scope="col">CANTIDAD</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach var="product" items="${listProducts}" varStatus="loop">
    <tr> 
     <form method="post" action="S_Add_Carrito">
         <input type="hidden" name="idProduc" value="${producto.idProduc}" >
         <input type="hidden" name="descProduct" value="${producto.descProduct}" >
         <input type="hidden" name="price" value="${producto.price}" >
         <th scope="row">${loop.index+1}</th>
         <td>${product.idProduc}</td>
         <td>${product.descProduct}</td>
         <td>${product.price}</td>
         <td>${product.stock}</td>
         <td><select name="cantidad">
             <option value="1" selected>1</option>
             <option value="2">2</option>
             <option value="3">3</option>
             <option value="4">4</option>
             <option value="5">5</option>
             </select></td>
         <td><button type="submit" name="add">añadir carrito</button></td>
         </form>
    </tr>
    </c:forEach>
    </tbody> 
</table>
<a href="categories">IR A CATEGORIAS</a><br>
<a href="carrito.jsp">ver carrito</a>(${total_productos})

</body>
</html>