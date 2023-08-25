<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Reclamo</title>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
</head>
<body>

	<jsp:include page="../template_superior.jsp"></jsp:include>

	<h1 class="pt-4">Formulario de Reclamo</h1>

	<form:form action="/reclamos/guardar" method="post"
		modelAttribute="formReclamo">

		<div class="pt-5">
			<table>
				<%-- <tr>
			<td><b>Id</b></td>
			<td><form:input path="id" readonly="true"/></td>
		</tr> --%>

				<div class="mb-3 py-2 px-5">
					<label for="exampleFormControlInput1" class="form-label h4">Título</label>
					<form:input type="text" class="form-control" path="titulo" />
				</div>

				<div class="mb-3 px-5">
					<label for="exampleFormControlTextarea1" class="form-label h4">Descripción</label>
					<form:textarea class="form-control" rows="3" path="descripcion" />
					</textarea>
				</div>

				<div class="px-5">
					<button class="btn btn-primary" type="submit">Guardar</button>
					<a href="/reclamos/listar"><button class="btn btn-danger" type="button">Cancelar</button></a>
				</div>

			</table>
		</div>

	</form:form>

	<jsp:include page="../template_inferior.jsp"></jsp:include>

</body>
</html>