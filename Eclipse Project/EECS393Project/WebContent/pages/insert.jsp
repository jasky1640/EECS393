<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>user register</title>
     
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
     <link rel = "stylesheet" href="<%=request.getContextPath()%>/css/LoginPage.css">
     
	  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js">//引入jquery框架
	  </script>
	  
	  <script type="text/javascript">
	   function insertUser()
	   {
		   //alert($("#user_name").val());
		    //var user_name=$("#name").val();
		    //var password=$("#password").val();
		    //alert(user_name);
			var user_type = -1;
			var opt = $("input[name='user']:checked");
			if(opt!=null&&opt.length==1){user_type=opt.val();}
			var user_name = $("#user_name").val();
			var user_password = $("#user_password").val();
		   window.location.href = "<%=request.getContextPath()%>/pages/doUserAdd.jsp?user_name="+user_name+"&user_password="+user_password+"&user_type="+user_type; 
	    }
	  </script>
	 
  </head>

  <body>
		 <div class = "login-page">
	      <div class = "form">
	                   <h3>Register </h3>
			  <form class="register-form" action="" method="POST">
			   <input id="user_name" name="user_name"  placeholder="User Name" >
			   <input id="user_password" name="user_password"  placeholder="User Password" >
			  <label> </label> <br>
			   	Student
				<input id="user2" type="radio" name="user" value="1" checked="checked"  /> <label for="user2"></label>
			    
			  <input type="button" onclick="insertUser();" value="Register" >
			   <a href="<%=request.getContextPath()%>/pages/login.jsp"> Return to Login Page</a>
		  	  </form>
		  </div>
		  </div>
		  
		  
  </body>
</html>