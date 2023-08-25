<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Reclamo</title>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
</head>
<body>

	<jsp:include page="../template_superior.jsp"></jsp:include>

	<h1 class="pt-4">Detalle del Reclamo</h1>

	<div class="pt-4 ps-4">
		<table>
			<tr>
				<td><b>Id:</b></td>
				<td class="ps-3 pt-2">${reclamo.id}</td>
			</tr>
			<tr>
				<td><b>Título:</b></td>
				<td class="ps-3 pt-2">${reclamo.titulo}</td>
			</tr>
			<tr>
				<td><b>Descripción:</b></td>
				<td class="ps-3 pt-2">${reclamo.descripcion}</td>
			</tr>
		</table>
	</div>

	<jsp:include page="../template_inferior.jsp"></jsp:include>

</body>
</html>