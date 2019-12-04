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
     
    <title>This is a course list page</title>
     
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
		 function exit() {
			window.opener=null;
			window.open("","_self");
			//window.close();
			history.back(1);
		};
	</script>
  </head>
  
  <body>

<form method="post" action="#">
<table>
	<thead>
		<tr>
			<th>course_id</th>
			<th>course_code</th>
			<th>name</th>
			<th>time_slots</th>
			<th>prerequisite_courses</th>
			<th>type</th>
			<th>depth</th>
			<th>credit_hour</th>
		</tr>
	</thead>
    <tbody>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="course" varStatus="vs">
					<tr>
						<td>course.course.course_id</td>
						<td>course.course_code</td>    
						<td>course.name</td>
						<td>course.time_slots</td>
						<td>course.prerequisite_courses</td>
						<td>course.type</td>
						<td>course.depth</td>  
						<td>course.credit_hour</td>                                         
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
    </tbody>
</table>
<br><br>
<input type="button" onclick="exit();" value="Return">
</form>

</body>
</html>