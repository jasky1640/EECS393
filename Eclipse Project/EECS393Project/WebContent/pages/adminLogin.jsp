<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login and Registration</title>
     	<link rel = "stylesheet" href="<%=request.getContextPath()%>/css/LoginPage.css">
</head>
<body>

		<div class = "login-page">
	    <div class = "form">
	            <h3>Login </h3>
	        <form class="register-form" action = "<%=request.getContextPath()%>/pages/doLogin.jsp" method="POST">
	        <input id="name" name="USER_NAME" type="text" placeholder="administrator_name" required/>
	        <input id="password" name="USER_PASSWORD" type="text" placeholder="administrator_password" required/>
	        <div style="display: inline-block;" >
	         
	         manager:<input type="radio" name="userType" value="0" checked="checked" >
	        </div> 
	        <input type="submit" name="Submit" value="Login" />
	        
	        </form>
	    </div>
	    </div>
	
	    <div class="admin-wrapper">
	
	    </div>
	
	    <script src='https://code.jquery.com/jquery-3.4.1.min.js'>
	    </script>
	
	    <script>
	    $('.message a').click(function(){
	        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	    });
	
	    </script>
	    
</body>
</html>