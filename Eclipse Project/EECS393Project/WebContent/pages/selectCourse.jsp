<%@ page language="java" import="java.util.*" import="dbconnect.*" import="entity.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Student Select Course</title>
     
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

#form{
	margin-top: 150px;
	margin-left: 450px;
}
 
#mytable {
	width: 800px;
	padding: 0;
	margin: 0;
}

#Btn{
height: 30px;
width: 100px;
margin-left: 200px;

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
	border-left: 1px solid #C1DAD7;
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
	border-right: 1px solid #C1DAD7;
	border-left: 1px solid #C1DAD7;
	background: none;
}
 
td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-left: 1px solid #C1DAD7;
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

    </style>
    
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
 			var track = -1;
			var opt = $("input[name='track']:checked");
			if(opt!=null&&opt.length==1){track=opt.val();}

			var bb = "";
			var temp = "";
			var a = $("input[name='course']:checked");
			if(a!=null){
				for(var i=0; i< a.length; i++){
					if(a[i].checked){
						temp = a[i].id;
						bb += temp + "_";
					}
				}
				bb = bb.substring(0, bb.length-1);
			}

			var windowFeatures = 'width='+(window.screen.availWidth-10)+',height='+(window.screen.availHeight-30)+',top=0,left=0,resizable=yes,status=yes,menubar=no,scrollbars=yes';
			var url="<%=request.getContextPath()%>/pages/doSelectCourse.jsp?courseSelected="+bb+"&track="+track;
			document.form1.action=url;
			var newwin = window.open('about:blank','UpdateUserCourse',windowFeatures);
			document.form1.target = 'UpdateUserCourse';
			document.form1.submit();
		}
	  </script>
	  
	    <script type="text/javascript">
		 function exit() {
			window.opener=null;
			window.open("","_self");
			//window.close();
			history.back(1);
		}
	</script>
	
  </head>

  <body>
  <div id = "form">
  <form id="form1" name="form1" action="" method="POST">
<!--      <input type="button" onclick="exit();" value="Finish"> -->
    <!--  <div align="left" style="float:left"><label>track setting: </label></div>
   	 <div align="left">
     	<input id="track1" type="radio" name="track" value="1" /> <label for="track1">Software Engineering</label>
		<input id="track2" type="radio" name="track" value="2" /> <label for="track2">Algorithms and Theory</label>
		<input id="track3" type="radio" name="track" value="3" /> <label for="track3">Computer Systems, Network</label>
		<input id="track4" type="radio" name="track" value="4" /> <label for="track4">Databases and Data Mining</label>
		<input id="track5" type="radio" name="track" value="5" /> <label for="track5">Bioinformatics</label>
		<input id="track6" type="radio" name="track" value="6" /> <label for="track6">Artificial Intelligence</label>
     </div> -->
     
      <table id="mytable"  cellspacing="0" summary="The technical specifications of the Apple PowerMac G5 series">
       <tr>  <td colspan="9" align="center" font-weight= "bold"> Select Track </td>  </tr>
      <tr>
    <th scope="col"><input id="track1" type="radio" name="track" value="1" /> <label for="track1">Software Engineering</label></th>
    <th scope="col" abbr="Dual 1.8"><input id="track2" type="radio" name="track" value="2" /> <label for="track2">Algorithms and Theory</label></th>
    <th scope="col" abbr="Dual 2"><input id="track3" type="radio" name="track" value="3" /> <label for="track3">Computer Systems, Network</label></th>
	<th scope="col" abbr="Dual 2.5"><input id="track4" type="radio" name="track" value="4" /> <label for="track4">Databases and Data Mining</label></th>  
	<th scope="col" abbr="Dual 2.5"><input id="track5" type="radio" name="track" value="5" /> <label for="track5">Bioinformatics</label></th>
	<th scope="col" abbr="Dual 2.5"><input id="track6" type="radio" name="track" value="6" /> <label for="track6">Artificial Intelligence</label></th>
	<tr>  <td colspan="9" align="center" font-weight= "bold"> Select Courses Taken </td>  </tr>
	</tr>
     
     <%
          List<String> list = DBCRUD.ListUniqueCourseCode();
     	  for(int i=0; i<list.size(); i++){
     		 String course_code = list.get(i);
     %>
          <% if(i%6==0){ %> <tr> <% } %>
		     <td>
		     	<input id="<%=course_code%>" type="checkbox" name="course" value="true"><%=course_code%>
		     </td>
	     <% if((i+1)%6==0){ %> </tr> <% } %>
	 <% } %>
     </table>
	 <input type="button" class id = "Btn" onclick="submitSelectedCourse();" value="Update">
	 
	 <input type="button" class id = "Btn" onclick="exit();" value="Return">
  </form>
  </div>
  </body>
</html>