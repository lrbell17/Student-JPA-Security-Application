<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Error</title>
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
	
	<p style="color:red">
		Sorry, you don't have access to this page! <br>
	</p>
	
	Possible Causes:
	<ul>
		<li>You don't have admin privileges</li>
		<li>The url is incorrect</li>
		<li>An error occurred</li>
	</ul>
</body>
</html>