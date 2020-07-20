<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Save File </title>
</head>
<body>

		Please enter a valid file name (.txt):
		<br>
		<p style="color:red"> ${errorMessage} </p>
		
		<form method="post"  action="filesave">
		
			File Name: <input type="text" name="filename"/><br>
	
		<input type="submit" />
	

	
	</form>
</body>
</html>