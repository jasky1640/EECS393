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
	padding:0;
	margin:0;
	text-align: center;
}
 
#btn{
	width: 100px;
	height: 30px;
	margin-left: 500px;
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
	text-align: center;
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
		 function exit() {
			window.opener=null;
			window.open("","_self");
			//window.close();
			history.back(1);
		}
		
		function plan(){
			
			var planNum = $("input[name='planCourses']:checked").val();
			
			//alert(planNum);
			window.location.href="<%=request.getContextPath()%>/pages/selectiveCoursesPlan.jsp?planNum="+planNum;
			
		}
		
		
		function submitSelectedCourse()
		{
			//selected course_code
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
			
			var windowFeatures = 'width='+(window.screen.availWidth-10)+',height='+(window.screen.availHeight-30)+',top=0,left=0,resizable=yes,status=yes,menubar=no,scrollbars=yes';
			var url="<%=request.getContextPath()%>/pages/doSelectiveCourses.jsp?op1="+op1+"&op2="+op2+"&op3="+op3+"&op4="+op4+"&op5="+op5;
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
	     <!-- Plan Courses -->
	     <div>
		    <!-- Plan1 -->
		    <div>
		     <table id="mytable"  cellspacing="0" summary="First Recommended Schedule">
       <tr>  <td colspan="9" align="center"> <input type="radio" name="planCourses" value="0" checked="checked">  Schedule 1 </td>  </tr>
		    <%
		    ArrayList<Course> list1 = plans.get(0).getCourseList();
		   	for (Course s1 : list1){
		   	 String cn1 = s1.getCourseName();
     		 String cc1 = s1.getCourseCode();
     		 String ct1 = Course.convertTimeSlotReadable(s1.getTimeSlot());
     		 int c1 = s1.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><%=cn1%></td><td width="100px" class="tddata"><%=cc1%></td><td width="800px" class="tddata"><%=ct1%></td><td width="100px" class="tddata"><%=c1%></td></tr>
			<% } %>
			</table>
		    </div><br/>
		    <!-- Plan2 -->
		    <div>
		    <table id="mytable"  cellspacing="0" summary="Second Recommended Schedule">
       <tr>  <td colspan="9" align="center"><input type="radio" name="planCourses" value="1"> Schedule 2 </td>  </tr>
		    <%
		    ArrayList<Course> list2 = plans.get(1).getCourseList();
		   	for (Course s2 : list2){
		   	 String cn2 = s2.getCourseName();
     		 String cc2 = s2.getCourseCode();
     		 String ct2 = Course.convertTimeSlotReadable(s2.getTimeSlot());
     		 int c2 = s2.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><%=cn2%></td><td width="100px" class="tddata"><%=cc2%></td><td width="800px" class="tddata"><%=ct2%></td><td width="100px" class="tddata"><%=c2%></td></tr>
			<% } %>
			</table>
		    </div><br/>
		    <!-- Plan3 -->
		    <div>
		    <table id="mytable"  cellspacing="0" summary="Third Recommended Schedule">
       <tr>  <td colspan="9" align="center"><input type="radio" name="planCourses" value="2"> Schedule 3 </td>  </tr>
		    <%
		    ArrayList<Course> list3 = plans.get(2).getCourseList();
		   	for (Course s3 : list3){
		   	 String cn3 = s3.getCourseName();
     		 String cc3 = s3.getCourseCode();
     		 String ct3 = Course.convertTimeSlotReadable(s3.getTimeSlot());
     		 int c3 = s3.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><%=cn3%></td><td width="100px" class="tddata"><%=cc3%></td><td width="800px" class="tddata"><%=ct3%></td><td width="100px" class="tddata"><%=c3%></td></tr>
			<% } %>
			</table>		    
		    </div><br/>
		    <!-- Plan4 -->
		    <div>
		    <table id="mytable"  cellspacing="0" summary="Fourth Recommended Schedule">
       <tr>  <td colspan="9" align="center"><input type="radio" name="planCourses" value="3"> Schedule 4 </td>  </tr>
		    <%
		    ArrayList<Course> list4 = plans.get(3).getCourseList();
		   	for (Course s4 : list4){
		   	 String cn4 = s4.getCourseName();
     		 String cc4 = s4.getCourseCode();
     		 String ct4 = Course.convertTimeSlotReadable(s4.getTimeSlot());
     		 int c4 = s4.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><%=cn4%></td><td width="100px" class="tddata"><%=cc4%></td><td width="800px" class="tddata"><%=ct4%></td><td width="100px" class="tddata"><%=c4%></td></tr>
			<% } %>
			</table>		    
		    </div><br/>
		    <!-- Plan5 -->
		    <div>
		    <table id="mytable"  cellspacing="0" summary="Fifth Recommended Schedule">
       <tr>  <td colspan="9" align="center"><input type="radio" name="planCourses" value="4"> Schedule 5 </td>  </tr>
		    <%
		    ArrayList<Course> list5 = plans.get(4).getCourseList();
		   	for (Course s5 : list5){
		   	 String cn5 = s5.getCourseName();
     		 String cc5 = s5.getCourseCode();
     		 String ct5 = Course.convertTimeSlotReadable(s5.getTimeSlot());
     		 int c5 = s5.getCredit();
     		 %>
     		 <tr><td width="400px" class="tddata"><%=cn5%></td><td width="100px" class="tddata"><%=cc5%></td><td width="800px" class="tddata"><%=ct5%></td><td width="100px" class="tddata"><%=c5%></td></tr>
			<% } %>
			</table>		    
		    </div><br/>
	    </div>
	
  </form>
   </center>
   <input type="button" class id = "btn" onclick="plan();" value="Submit">
	 
	  <input type="button" class id = "btn" onclick="exit();" value="Return">
  </body>
</html>