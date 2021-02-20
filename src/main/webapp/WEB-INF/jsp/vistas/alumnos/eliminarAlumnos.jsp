<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	
	<%@include file="../../menu.html"%>
	
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/formularioeliminaralumno" method="post">
				<label for="id">Id Alumno</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre" name="nombre">
				<br> 
				<input type="submit" value="Enviar">
			</form>
		</div>	
		<h2>Eliminar alumno</h2>
		<c:forEach items="${lista}" var="alumno">
			<div class="form">
				<form action="http://localhost:8080/colegio/eliminaralumno" method="post">
				
					<label for="id">Id Alumno</label> 
					<input type="text" id="id"	name="id" value="${alumno.id}" readonly> 
					
					<label for="nombre">Nombre Alumno</label> 
					<input type="text" id="nombre" name="nombre" value="${alumno.nombre}" readonly><br> 
					
					<label for="nombre">Municipio</label> 					
					<input type="text" id="municipio" name="municipio" value="${alumno.municipio}" readonly>					
					
					<input type="submit" value="Eliminar">
				</form>
			</div>
		</c:forEach>
	
	</div> <!-- Fin container -->
	