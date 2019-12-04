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
     
    <title>Course Find by ID Page</title>
     
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

<form method="post" action="<%=request.getContextPath() %>/pages/doCourseList.jsp">
<%
	int course_id = Integer.parseInt(request.getParameter("course_id"));

	List<Course> list = DBCRUD.FindCourse(course_id);
	request.setAttribute("list", list);
%>
<br><br>
<input type="submit" name="display" value="display course">
<input type="reset" value="reset">
</form>

</body>
</html>