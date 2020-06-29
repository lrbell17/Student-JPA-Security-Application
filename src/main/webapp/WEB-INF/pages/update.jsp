<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	Update user
		
		<form method="post"  action="update">
		
		Student Id: <input type="hidden" name="id" value ="${id}"/><br>
		
		Name: <input type="text" name="stuName"/><br>
		
		Address: <input type="text" name="stuAddress" /><br>
		
		<input type="submit" />
	
	
	</form>
</body>
</html>