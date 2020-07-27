<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Save File </title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style>
	
		body {
			margin: 50px 50px;
		}
	</style>
</head>
<body>
		<%@ include file="menu.jsp" %>

		Please enter a valid file name (.txt):
		<br>
		<p style="color:red"> ${errorMessage} </p>
		
		<form method="post"  action="filesave" class="form-group">
		
			File Name: <input type="text" name="filename"/><br>
	
		<input type="submit" />
	

	
	</form>
</body>
</html>