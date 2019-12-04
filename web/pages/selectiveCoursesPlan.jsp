<%@ page language="java" import="java.util.*" import="dbconnect.*" import="generator.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Selective Courses</title>
     
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <style type="text/css">
  
  body {
	background-image: url(css/2.jpg);
		    height: 100vh;
		    background-size: cover;
		    background-position: center;
		    margin: 0;
		    padding: 0;
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
	border-left: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}
 
 #btn{
	width: 100px;
	height: 30px;
	margin-left: 500px;
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
	border-left: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
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
		 function exit() {
			window.opener=null;
			window.open("","_self");
			//window.close();
			history.back(1);
		}
		
		
		function submitSelectedCourse()
		{
			//selected course_code
			var planNum="<%=request.getParameter("planNum")%>";
			var op1=-1;
			var op2=-1;
			var op3=-1;
			var op4=-1;
			var op5=-1;
			
			var ap1 = $("input[name='op1']:checked");
			if(ap1!=null&&ap1.length==1){op1 = ap1.val();}
			var ap2 = $("input[name='op2']:checked");
			if(ap2!=null&&ap2.length==1){op2 = ap2.val();}
			var ap3 = $("input[name='op3']:checked");
			if(ap3!=null&&ap3.length==1){op3 = ap3.val();}
			var ap4 = $("input[name='op4']:checked");
			if(ap4!=null&&ap4.length==1){op4 = ap4.val();}
			var ap5 = $("input[name='op5']:checked");
			if(ap5!=null&&ap5.length==1){op5 = ap5.val();}
			
			var ocn1=$("input[name='op1']:checked").attr("ocn1");
			var oct1=$("input[name='op1']:checked").attr("oct1");
			
			var oc1= $("input[name='op1']:checked").attr("oc1");
			
			
			var windowFeatures = 'width='+(window.screen.availWidth-10)+',height='+(window.screen.availHeight-30)+',top=0,left=0,resizable=yes,status=yes,menubar=no,scrollbars=yes';
			var url="<%=request.getContextPath()%>/pages/doSelectiveCourses.jsp?op1="+op1+"&op2="+op2+"&op3="+op3+"&op4="+op4+"&op5="+op5+"&planNum="+planNum+"&ocn1="+ocn1+"&oct1="+oct1+"&oc1="+oc1;
			//alert(url);
			document.form1.action=url;
			var newwin = window.open('about:blank','SelectiveCourses',windowFeatures);
			document.form1.target = 'SelectiveCourses';
			document.form1.submit();
		}
	  </script>
  </head>

  <body>
  
  <center>
  <form id="form1" name="form1" action="" method="POST">
<!--      <input type="button" onclick="exit();" value="Finish"> -->

     <%
	     List<entity.User> list = dbconnect.DBCRUD.FindUser(AppData.curLoginUser.getUser_id());
	     generator.User xx = new User(list.get(0).getUser_name(),list.get(0).getTrack());
	
     	//Plans
	     ArrayList<Plan> plans = new ArrayList<Plan> ();
	     plans = Generator.generate(CourseDBConnect.getCourseDBConnectInstance().getAllHighPriorityCoursesByPriority(), xx);
	%>
	  
	    
	    <!-- Options -->
	     <div>
		    <!-- Option1 -->
		    <div>
		    <table id="mytable"  cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
		    <%
		    Integer planNum=Integer.parseInt(request.getParameter("planNum"));
		    
		    ArrayList<Course> option1 = Generator.getLPoptions(xx, plans.get(planNum));
			int idx1=0;
		   	for (Course os1 : option1){
		   	 String ocn1 = os1.getCourseName();
     		 String occ1 = os1.getCourseCode();
     		 String oct1 = Course.convertTimeSlotReadable(os1.getTimeSlot());
     		 int oc1 = os1.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><input id="op1<%=idx1%>" type="radio" name="op1" ocn1="<%=ocn1%>" oct1="<%=oct1%>"  oc1="<%=oc1%>" value="<%=occ1%>" /><%=ocn1%></td><td width="100px" class="tddata"><%=occ1%></td><td width="800px" class="tddata"><%=oct1%></td><td width="800px" class="tddata"><%=oc1%></td></tr>

			<% idx1++; } %>
			</table>
		    </div><br/>
		    <br/>
	    </div> 
	
  </form>
  </center>
  
   <input type="button" class id = "btn" onclick="submitSelectedCourse();" value="Submit">
	 
	  <input type="button" class id = "btn" onclick="exit();" value="Return">
	  
  </body>
</html>