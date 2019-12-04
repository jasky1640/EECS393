<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="dbconnect.*" import="entity.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>User Find by Properties Page</title>
     
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    
	  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js">//引入jquery框架
	  </script>
	  <script type="text/javascript">
	  </script>
  </head>
  
  <body>

<form method="post" action="<%=request.getContextPath() %>/pages/doUserList.jsp">
<%
	//int user_id = Integer.parseInt(request.getParameter("user_id"));
	String user_name = request.getParameter("user_name");
	String user_password = request.getParameter("user_password");
	int user_type = Integer.parseInt(request.getParameter("user_type"));
	String core = request.getParameter("core");
	String breadth = request.getParameter("breadth");
	String depth = request.getParameter("depth");
	String general = request.getParameter("general");
	String technical_elective = request.getParameter("technical_elective");
	int track = Integer.parseInt(request.getParameter("track"));
	
	List<User> list = DBCRUD.FindUser(user_name, user_password, user_type, core, breadth, depth, general, technical_elective, track);	
	request.setAttribute("list", list);
%>
<br><br>
<input type="submit" name="display" value="display user">
<input type="reset" value="reset">
</form>

</body>
</html>