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
	
	<h2>Welcome!</h2>
	Student Id: <p>${student.stuId} </p> <br>
	Name: <p> ${student.firstName} ${student.lastName} </p><br>
	Username: <p> ${student.username} </p><br>
	Password: <p> ${student.password} </p>
	GPA: <p> ${student.gpa}</p>


	<br>
	
	<a type="button" href="/findbyname">Find student by name</a> | 
	<a type="button" href="/findbyid">Find student by ID</a><br>


</body>
</html>