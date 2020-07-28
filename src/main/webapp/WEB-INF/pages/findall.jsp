<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>All Students</title>
	
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
		
		<p style="color:blue"> ${successMessage} </p>
		<p style="color:red"> ${errorMessage} </p>
		
		<table class="table">
			<thead>
				<tr>
					<th>Student Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
					<th>Password</th>
					<th>GPA</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.stuId}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.username}</td>
						<td>${student.password}</td>
						<td>${student.gpa}</td>
						<td><a type="button" 
							href="/update?id=${student.stuId}">Update</a></td>
						<td><a type="button"
							href="/delete?id=${student.stuId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<br>
		<a type="button" href="/filesave"> Save Data </a> <br>

</body>
</html>