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
     
    <title>This is a user list page</title>
     
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
			<th>user_id</th>
			<th>user_name</th>
			<th>user_password</th>
			<th>user_type</th>
			<th>core</th>
			<th>breadth</th>
			<th>depth</th>
			<th>general</th>
			<th>technical_elective</th>
			<th>track</th>
		</tr>
	</thead>
    <tbody>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="user" varStatus="vs">
					<tr>
						<td>user.user_id</td>
						<td>user.user_name</td>
						<td>user.user_password</td>
						<td>user.user_type</td>
						<td>user.core</td>
						<td>user.breadtd</td>
						<td>user.deptd</td>
						<td>user.general</td>
						<td>user.technical_elective</td>
						<td>user.track</td>                                        
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