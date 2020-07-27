<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
	
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

	<h2>Add student information here</h2>

	<p style="color:red"> ${errorMessage} </p>
	<form:form method="post" modelAttribute="student" action="welcome" class="form-group">
		
		First Name: <form:input type="text" path="firstName"/><br><br>
		
		Last Name: <form:input type="text" path="lastName" /> <br><br>
		
		Username: <form:input type="text" path="username"/><br><br>
		
		Password: <form:input type="password" path="password"/> <br><br>
		
		GPA: <form:input path="gpa" type="number" placeholder="0.00" step="0.01" min="0" max="4" /><br><br>
		
		<input type="submit" />
	
	
	</form:form>
</body>
</html>