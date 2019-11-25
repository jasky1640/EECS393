<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome</title>
        <link rel = "stylesheet" href="welcome/welcomeStyle.css">
</head>

<body>
	<div class = "container">
        <a href="<%=request.getContextPath()%>/pages/login.jsp">
            <button class="btn button1">I am a student</button>
        </a>
        <a href="<%=request.getContextPath()%>/pages/adminLogin.jsp">
            <button class="btn button2">I am an administrator</button>
        </a>
    </div>

</body>
</html>