<%@ page language="java" import="java.util.*" import="dbconnect.*" import="generator.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Update Selective Courses</title>
     
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
	text-align: center;
	background-image: url(css/2.jpg);
	height: 100vh;
	background-size: cover;
	background-position: center;
	margin: 0;
	padding: 0;
	opacity: 0.95;
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

#form{
	margin-left: 550px;
	margin-top: 200px;
}

input{
	height: 20px;
	width: 100px;
	margin-right: 550px;
}
 
th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	border-left: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}
 
th.nobg {
	border-top: 1px solid #C1DAD7;
	border-left: 1px solid #C1DAD7;
	border-right: 1px solid #C1DAD7;
	background: none;
}
 
td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-left: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
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
	border-top: 1px solid #C1DAD7;
	background: #fff url(images/bullet1.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}
 
th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	background: #f5fafa url(images/bullet2.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}

    </style>
    
    <style>
		.tabledate{  <!----table style--->
			border: 1px solid black;
			border-collapse:collapse;
		}
		.tddata{  <!---td style---->
			border: 1px solid black;
		}
	</style>
	
	  <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js">//introduce jquery framework
	  </script>
	  <script type="text/javascript">
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
 <div id = "form">
<form>
     <%
	     String op1 = request.getParameter("op1");
	     String op2 = request.getParameter("op2");
	     String op3 = request.getParameter("op3");
	     String op4 = request.getParameter("op4");
	     String op5 = request.getParameter("op5");
	     
	     String ocn1 = request.getParameter("ocn1");
	     String oct1 = request.getParameter("oct1");
	     String oc1 = request.getParameter("oc1");

     
	     List<entity.User> list = dbconnect.DBCRUD.FindUser(AppData.curLoginUser.getUser_id());
	     generator.User xx = new User(list.get(0).getUser_name(),list.get(0).getTrack());
	
     	//Plans
	     ArrayList<Plan> plans = new ArrayList<Plan> ();
	     plans = Generator.generate(CourseDBConnect.getCourseDBConnectInstance().getAllHighPriorityCoursesByPriority(), xx);
	%>
	     <!-- Plan Courses -->
	     <div>
		    <!-- Plan1 -->
		    <div>
		     <table id="mytable"  cellspacing="0" summary="The Final Recommended Schedule">
		     <tr>  <td colspan="9" align="center">  Final Schedule </td>  </tr>
		    <%
		    
		    Integer planNum=Integer.parseInt(request.getParameter("planNum"));
		    
		    ArrayList<Course> list1 = plans.get(planNum).getCourseList();
		   	for (Course s1 : list1){
		   	 String cn1 = s1.getCourseName();
     		 String cc1 = s1.getCourseCode();
     		 String ct1 = Course.convertTimeSlotReadable(s1.getTimeSlot());
     		 int c1 = s1.getCredit();
     		 
     		 %>
     		 <tr>
     		 <td width="100px" class="tddata"><%=cn1%></td>
     		  <td width="100px" class="tddata"><%=ct1%></td>
     		   <td width="100px" class="tddata"><%=cc1%></td>
     		   <td width="100px" class="tddata"><%=c1%></td>
     		   
     		 </tr>
			<% } %>
			<% if(op1!=null && !op1.equals("-1")){ %>
			
			<tr><td width="100px" class="tddata"><%=ocn1%></td>
			<td width="100px" class="tddata"><%=oct1%></td>
			<td width="100px" class="tddata"><%=op1%></td>
			<td width="100px" class="tddata"><%=oc1%></td>
			</tr>
			<% } %>
			</table>
		    </div>
	    </div>
	    
    <div>
		<input type="button" onclick="window.close();" value="Close">
    </div>
    </div>
</form>

</body>
</html>