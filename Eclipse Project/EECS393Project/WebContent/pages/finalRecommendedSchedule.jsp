<%@ page language="java" import="java.util.*" import="dbconnect.*" import="generator.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Final Recommended Schedule</title>
     
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
		}
		function submitSelectedCourse()
		{
			var bb = "";
			var temp = "";
			var a = $("input[name='course']:checked");
			for(var i=0; i< a.length; i++){
				if(a[i].checked){
					temp = a[i].id;
					bb += temp + "_";
				}
			}
			bb = bb.substring(0, bb.length-1);
			var windowFeatures = "width=800,height=600,top=0,left=0";
			var url="<%=request.getContextPath()%>/pages/doFinalRecommendedSchedule.jsp?fnlRcmdSchedule="+bb;
			document.form1.action=url;
			var newwin = window.open('about:blank','FinalRecommendedSchedule',windowFeatures);
			document.form1.target = 'FinalRecommendedSchedule';
			document.form1.submit();
		}
	  </script>
  </head>

  <body>
  <form id="form1" name="form1" action="" method="POST">
<!--      <input type="button" onclick="exit();" value="Finish"> -->
     <table>
     <%
         List<entity.User> list = dbconnect.DBCRUD.FindUser(AppData.curLoginUser.getUser_id());
	     generator.User xx = new User(list.get(0).getUser_name(),list.get(0).getTrack());
	
     	//Plans
	     ArrayList<Plan> plans = new ArrayList<Plan> ();
	     plans = Generator.generate(CourseDBConnect.getCourseDBConnectInstance().getAllHighPriorityCoursesByPriority(), xx);
	     for (int j = 0; j < plans.size(); j++){
	 %>
	 	<tr>
		 <%
		     //Options
		     ArrayList<Course> options = Generator.getLPoptions(xx, plans.get(j));
		     for (int i = 0; i < options.size(); i++){
	     		 String course_code = options.get(i).getCourseCode();
	     %>
		     <td>
		     	<input id="<%=course_code%>" type="checkbox" name="course" value="true"><%=course_code%>
		     </td>
		 <% } %>
	 	</tr>
	 <% } %>
     </table>
	 <input type="button" onclick="submitSelectedCourse();" value="Submit">
  </form>
  </body>
</html>