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
    <style type="text/css">
  
  body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}
 
a {
	color: #c75f3e;
}
 
#mytable {
	width: 700px;
	padding: 0;
	margin: 0;
}
 
caption {
	padding: 0 0 5px 0;
	width: 700px;	 
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}
 
th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}
 
th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}
 
td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}
 
 
td.alt {
	background: #F5FAFA;
	color: #797268;
}
 
th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(images/bullet1.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}
 
th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(images/bullet2.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}


.gradientTable {
    width: auto;
    padding: 0;
    border-spacing: 0px;
}
 
    .gradientTable th {
        font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        color: #4f6b72;
        border-right: 1px solid #C1DAD7;
        border-bottom: 1px solid #C1DAD7;
        border-top: 1px solid #C1DAD7;
        letter-spacing: 2px;
        text-transform: uppercase;
        text-align: left;
        padding: 6px 6px 6px 12px;
        background: #CAE8EA url(/images/bg_header.jpg) no-repeat;
    }
 
        .gradientTable th.nobg {
            border-top: 0;
            border-left: 0;
            border-right: 1px solid #C1DAD7;
            background: none;
        }
 
    .gradientTable td {
        border-right: 1px solid #C1DAD7;
        border-bottom: 1px solid #C1DAD7;
        font-size: 11px;
        padding: 6px 6px 6px 12px;
        color: #4f6b72;
    }
 
    .gradientTable tr:nth-child(odd) {
        background: #fff;
    }
 
    .gradientTable tr:nth-child(even) {
        background: #F5FAFA;
    }

    </style>
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
  
  <table id="mytable"  cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
<caption>
<input type="button" onclick="window.location.href='<%=request.getContextPath()%>/pages/courseAdd.jsp'" value="Add Course"> 
| <a href="<%=request.getContextPath()%>/pages/login.jsp"> return login </a> </caption>
  <tr>
    <th scope="col">course_id</th>
    <th scope="col" abbr="Dual 1.8">course_code</th>
    <th scope="col" abbr="Dual 2">name</th>
	<th scope="col" abbr="Dual 2.5">time_slots</th>  
	<th scope="col" abbr="Dual 2.5">prerequisite_courses</th>
	<th scope="col" abbr="Dual 2.5">type</th>
	<th scope="col" abbr="Dual 2.5">depth</th>
	<th scope="col" abbr="Dual 2.5">credit_hour</th>
	<th scope="col" abbr="Dual 2.5">operation</th>
  </tr>
    <%
          List<Course> list = DBCRUD.ListCourses();
     	  for(Course course : list){
     %>
  <tr>
    <th scope="row" abbr="Model" class="spec"><%=course.getCourse_id()%></th>
    <td><%=course.getCourse_code()%></td>
	<td><%=course.getName()%></td>
	<td><%=course.getTime_slots()%></td>
	<td><%=course.getPrerequisite_courses()%></td>
	<td><%=course.getType()%></td>
	<td><%=course.getDepth()%></td>
	<td><%=course.getCredit_hour()%></td>
     <td>
		 <a onclick="if(confirm('confirm delete?')==false)return false;" href="<%=request.getContextPath()%>/pages/doCourseDel.jsp?course_id=<%=course.getCourse_id()%>">delete </a> 
		 
		  <a href="<%=request.getContextPath()%>/pages/courseUpdate.jsp?course_id=<%=course.getCourse_id()%>"> update </a>       	
    </td>
  </tr>
  <% } %>
</table>


  </body>
</html>