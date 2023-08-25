<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listado de Reclamos</title>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<link href="../css/bootstrap.css" rel="stylesheet" />
	
</head>
<body>

		<jsp:include page="../template_superior.jsp"></jsp:include>
	<div class="py-4">
		<h3 class="text-center">${titulo}</h3>
	</div>
		
	
	
		<table class="table table-bordered border-primary">
		
			<tr>
				<th class="text-center">Id</th>
				<th class="text-center">Titulo</th>
				<th class="text-center">Fecha alta</th>
				<th class="text-center">Estado</th>
				<th class="text-center">Botonera</th>
			</tr>
			
			<c:forEach items="${reclamos}" var="reclamo">
			<tr>
				<td class="text-center">${reclamo.id}</td>
				<td>${reclamo.titulo}</td>
				<td>${reclamo.fechaDeAlta}</td>
				<td>${reclamo.estadoReclamo.nombre}</td>
				<td class="d-flex justify-content-center">
					<a class="btn btn-primary" href="/reclamos/ver/${reclamo.id}">Ver</a>
					&nbsp;
					<a class="btn btn-info" href="/reclamos/editar/${reclamo.id}">Editar</a>
					&nbsp;
					<a class="btn btn-danger" href="/reclamos/borrar/${reclamo.id}">Borrar</a>
				</td>
			</tr>
			</c:forEach>
		</table>

			<jsp:include page="../template_inferior.jsp"></jsp:include>
	

</body>
</html>