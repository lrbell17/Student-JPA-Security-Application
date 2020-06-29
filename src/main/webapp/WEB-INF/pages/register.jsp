<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<h2>Register Here</h2>

	<form:form method="post" modelAttribute="student" action="welcome">
		
		Student Id: <form:input type="text" path="stuId"/><br>
		
		Name: <form:input type="text" path="stuName"/><br>
		
		Address: <form:input type="text" path="stuAddress" /><br>
		
		<input type="submit" />
	
	
	</form:form>
</body>
</html>