<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>

<!DOCTYPE html>
<html lang="en">
<head>
 	<meta charset="ISO-8859-1">
	<title>Login</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style>
	
		body {
			margin: 50px 50px;
		}
	</style>
</head>

<body>


	<h2 > Log in </h2>
	
	<p style="color:blue"> ${msg} </p>
	
	<p style="color:red"> ${errorMsg} </p>
	
    <form method="POST" action="/login" class="form-group">
		
        <div class="form-group ">
            	
            	Username: <input type="text" name="username" placeholder="Username" /><br><br>
		
				Password: <input type="password" name="password" placeholder="Password" /> <br><br>
				
       			<input type="submit" />
        </div>

    </form>

</body>
</html>