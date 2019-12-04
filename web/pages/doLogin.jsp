<%@ page language="java" import="java.util.*" import="dbconnect.*" import="entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>This is user login page</title>
     
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <style>
    
    	body{
			background-image: url(css/2.jpg);
		    height: 100vh;
		    background-size: cover;
		    background-position: center;
		    margin: 0;
		    padding: 0;
		}
    	#form{
	    	width: 450px;
	    	height: 330px;
	    	margin-top: 150px;
	    	margin-left: 600px;
	    	margin-right: 600px;
	    	background: white;
	    	align-items: center;
	    	padding: 100px, 30px;
		}
		.Btn{
			width: 300px;
			height: 30px;
			color:white;
			background-color:cornflowerblue;
			border-radius: 3px;
			border-width: 0;
			margin: 20px;
			outline: none;
			font-family: KaiTi;
			font-size: 17px;
			text-align: center;
			cursor: pointer;
			margin-left: 80px;
		}
		.Btn:hover{
			background-color: antiquewhite;
		}
		.string{
			font-size: 30px;
			margin-left: 100px;
		}
		.s{
			font-size: 13px;
			margin-left: 20px;
			margin-right: 20px;
		}
		
	</style>

    
	  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js">
	  </script>
	  <script type="text/javascript">
	  </script>
	  
	  <script type="text/javascript">
		 function exit() {
			window.opener=null;
			window.open("","_self");
			//window.close();
			history.back(1);
		}
	</script>
  </head>
  
  <body>

<form>
<div id = "form">
<%


	String USER_NAME = request.getParameter("USER_NAME");
	String USER_PASSWORD = request.getParameter("USER_PASSWORD");
	String userType = request.getParameter("userType");
	
	List<User> list = DBCRUD.UserLogin(USER_NAME, USER_PASSWORD,userType);
	String strRtn = "Login successfully!";
	int user_type = -1;
	if(list!=null && list.size()==1)
	{
		user_type = list.get(0).getUser_type();
		if(user_type==0)//Administrator
		{
			strRtn = "Welcome! "+USER_NAME+"";
		}
		else //Student
		{
			strRtn = "Welcome! "+USER_NAME+"";
		}
	}
	else
	{
		strRtn = "Login failure! ["+USER_NAME+"]";
	}
%>

	     
	     
	    	<div class = "string">
	        <%=strRtn%>&nbsp;&nbsp;&nbsp;
	    	</div>
	    	<p class = "s" > If this is your first time using this system, please click the "Select Track And Courses Taken" button to update your personal information.</p>
	    	<div >
	    	<% if(user_type==0){ %>
	        	<input type="button" class="Btn" onclick="window.location.href='<%=request.getContextPath()%>/pages/courseManageAll.jsp'" value="Course Manage">
	        	&nbsp;&nbsp;&nbsp;
	        	<input type="button" class="Btn" onclick="exit();" value="Relogin">
	        <% }else if(user_type==1){ %>
	        	<input type="button" class="Btn" onclick="window.location.href='<%=request.getContextPath()%>/pages/selectCourse.jsp'" value="Select Track And Courses Taken">
	        	&nbsp;&nbsp;&nbsp;
	        	<input type="button" class="Btn" onclick="window.location.href='<%=request.getContextPath()%>/pages/selectiveCourses.jsp'" value="Generate Schedule">
	        	&nbsp;&nbsp;&nbsp;
	        	<input type="button" class="Btn" onclick="exit();" value="Relogin">
	        <% }else{ %>
	        	<input type="button" class="Btn" onclick="exit();" value="Relogin">
	        <% } %>
	   			 </div>
	   		 
	  
  </div>
</form>

</body>
</html>