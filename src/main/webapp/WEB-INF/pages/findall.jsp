<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<body>
		<p style="color:blue"> ${sucessMessage} </p>
		
		<table>
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Address</th>
					<th></th>
				</tr>

				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.stuId}</td>
						<td>${student.stuName}</td>
						<td>${student.stuAddress}</td>
						<td><a type="button" 
							href="/update?id=${student.stuId}">Update</a></td>
						<td><a type="button"
							href="/delete?id=${student.stuId}">Delete</a></td>
					</tr>
				</c:forEach>

		</table>

		<br>
		<a type="button" href="/filesave"> Save Data </a> 
</body>
</html>