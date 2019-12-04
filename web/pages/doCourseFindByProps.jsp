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
     
    <title>Course Find by Properties</title>
     
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
	String course_code = request.getParameter("course_code");
	String name = request.getParameter("name");
	String time_slots = request.getParameter("time_slots");
	String prerequisite_courses = request.getParameter("prerequisite_courses");
	String type = request.getParameter("type");
	int depth = Integer.parseInt(request.getParameter("depth"));
	long credit_hour = Long.parseLong(request.getParameter("credit_hour"));
	
	List<Course> list = DBCRUD.FindCourse(course_code,name,time_slots,prerequisite_courses,type,depth,credit_hour);
	request.setAttribute("list", list);
%>
<br><br>
<input type="submit" name="display" value="display course">
<input type="reset" value="reset">
</form>

</body>
</html>