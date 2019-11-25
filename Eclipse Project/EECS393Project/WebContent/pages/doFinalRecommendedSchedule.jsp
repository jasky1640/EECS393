<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="dbconnect.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>Update Final Recommended Schedule</title>
     
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

<form>
<%

	String fnlRcmdSchedule = request.getParameter("fnlRcmdSchedule");

	boolean isOK = true;//need execute right method to modify user record;
	String strRtn = "Update Final Recommended Schedule successfully";
	if(!isOK)
	{
		strRtn = "Update Final Recommended Schedule failure";
	}
%>
    <div align="left" style="float:left">
        <%=strRtn%>&nbsp;&nbsp;&nbsp;
    </div>
    <div align="left">
		<input type="button" onclick="window.close();" value="Close">
    </div>
</form>

</body>
</html>