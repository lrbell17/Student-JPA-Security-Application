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
	<h2>Welcome!</h2>
	Student Id: <c:out value="${student.stuId}"/> <br>
	Name: <c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/><br>
	Password: <c:out value="${student.password}"/><br>
	GPA: <c:out value="${student.gpa}"/><br>


	<br>
	<a type="button" href="/findall">List of all students</a> | 
	<a type="button" href="/findbyname">Find student by name</a> | 
	<a type="button" href="/findbyid">Find student by ID</a><br>

	<a type="button" href="/register">Add student</a>

</body>
</html>