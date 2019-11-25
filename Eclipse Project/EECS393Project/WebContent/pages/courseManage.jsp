<%@ page language="java" import="java.util.*" import="dbconnect.*" import="entity.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Administrator Manage Course</title>
     
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
	   function insertUser()
	   {
		   alert("ok");
		    var user_name=$("#name").val();
		    var password=$("#password").val();
		    alert(user_name);
	    }
	  </script>
  </head>

  <body>
  <form action="#" method="POST">
     <table>
     <%
          List<String> list = DBCRUD.ListUniqueCourseCode();
     	  for(String course_code : list){
     %>
	     <tr>
		     <td>
		     	<input type="checkbox" name="<%=course_code%>" value="true">
		     </td>
		     <td>
		     	<input id="track1" type="radio" name="track" value="1" /> <label for="track1">Software Engineering</label>
				<input id="track2" type="radio" name="track" value="2" /> <label for="track2">Algorithms and Theory</label>
				<input id="track3" type="radio" name="track" value="3" /> <label for="track3">Computer Systems, Network</label>
				<input id="track4" type="radio" name="track" value="4" /> <label for="track4">Databases and Data Mining</label>
				<input id="track5" type="radio" name="track" value="5" /> <label for="track5">Bioinformatics</label>
				<input id="track6" type="radio" name="track" value="6" /> <label for="track6">Artificial Intelligence</label>
		     </td>
		     <td>
		     	<input type="button" onclick="window.location.href='<%=request.getContextPath()%>/pages/doCourseAdd.jsp'" value="Add Course">
		     </td>
	     </tr>
	     <% } %>
     </table>
  </form>
  </body>
</html>