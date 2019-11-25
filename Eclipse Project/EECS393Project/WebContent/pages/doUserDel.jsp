<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="dbconnect.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>User Del Page</title>
     
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
	int user_id = Integer.parseInt(request.getParameter("user_id"));

	DBCRUD.DelUser(user_id);
%>
<br><br>
<input type="submit" name="display" value="display user">
<input type="reset" value="reset">
</form>

</body>
</html>