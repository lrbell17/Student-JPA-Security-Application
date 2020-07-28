<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Find Student By Name</title>
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
		
		<h2>Find Student by Username</h2>
		
		<p style="color:red"> ${errorMsg} </p>
		
		<form method="post"  action="findbyuname">
		
		Student's First Name: <input type="text" name="uname" placeholder="Username" required/><br><br>
	
		<input type="submit" />
	
	
	</form>
</body>
</html>