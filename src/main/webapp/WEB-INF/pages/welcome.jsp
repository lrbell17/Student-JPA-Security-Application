<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome!</h2>
	Student Id: <c:out value="${student.stuId}"/> <br>
	Name: <c:out value="${student.stuName}"/><br>
	Address: <c:out value="${student.stuAddress}"/><br>


	<br>
	<a type="button" href="/findall">List of all students</a> | 
	<a type="button" href="/findbyname">Find student by name</a> | 
	<a type="button" href="/findbyid">Find student by ID</a><br>

	<a type="button" href="/register">Add student</a>

</body>
</html>