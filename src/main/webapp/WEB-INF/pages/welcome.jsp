<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style>
	
		body {
			margin: 50px 50px;
		}
	</style>
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<h2>Student:</h2>

	<!-- only displays password to admin -->
	<c:choose>
		<c:when test="${role=='ADMIN'}">
			<c:set var="pass" value="${student.password}" />
		</c:when>
		<c:otherwise>
			<c:set var="pass" value="(hidden)" />
		</c:otherwise>
	</c:choose>

	Student Id: <p>${student.stuId} </p> <br>
	Name: <p> ${student.firstName} ${student.lastName} </p><br>
	Username: <p> ${student.username} </p><br>
	Password: <p> ${pass} </p>
	GPA: <p> ${student.gpa}</p>


	<br>


</body>
</html>