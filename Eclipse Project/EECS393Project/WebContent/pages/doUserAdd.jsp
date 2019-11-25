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
     
    <title>User Add Page</title>
     
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style>
    
    body{
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
	
	
    #class{
    position: relative;
    z-index: 1;
    background: white;
    max-width: 360px;
    margin-left: 650px;
    margin-top: 250px;
    padding: 45px;	
    text-align: center;
    }
    
    .Btn{
    margin: 30px;
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
	</script>
  </head>
  
  <body>

<form method="post" action="<%=request.getContextPath() %>/pages/doUserList.jsp">
<%
	//int user_id = "";
	String user_name = "";
	String user_password = "";
	int user_type = -1;
	String core = "";
	String breadth = "";
	String depth = "";
	String general = "";
	String technical_elective = "";
	String strRtn="";
	int track = -1;

	//user_id = Integer.parseInt(request.getParameter("user_id"));
	user_name = request.getParameter("user_name");
	user_password = request.getParameter("user_password");
	String utype = request.getParameter("user_type");
	if(utype!=null)
	{
		try{
			user_type = Integer.parseInt(utype);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	core = request.getParameter("core");
	breadth = request.getParameter("breadth");
	depth = request.getParameter("depth");
	general = request.getParameter("general");
	technical_elective = request.getParameter("technical_elective");
	String s_track = request.getParameter("track");
	if(s_track!=null)
	{
		try{
			track = Integer.parseInt(s_track);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	ArrayList lists=DBCRUD.getUserByUserName(user_name,utype);
	if(lists==null || lists.size()==0){
		boolean bRtn =DBCRUD.AddUser(user_name, user_password, user_type, core, breadth, depth, general, technical_elective, track);
		 strRtn = "User["+user_name+"] Register successfully!";
		if(!bRtn)
		{
			strRtn = "User["+user_name+"] Register failure!";
		}
	}else{
		    strRtn = "User["+user_name+"] Register failure,user_name Already exist!";	
	}
/*	
	String user_name = request.getParameter("user_name");
	String user_password = request.getParameter("user_password");
	//UserInfoDBConnect uidbc = new UserInfoDBConnect();

	boolean bRtn = UserInfoDBConnect.insertUser(user_name, user_password);
	String strRtn = "User ["+user_name+"] Register Successfully!";
	if(!bRtn)
	{
		strRtn = "User ["+user_name+"] Register Failure!";
	}
*/	
%>

<div id = "class">
    <div>
        <%=strRtn%>&nbsp;&nbsp;&nbsp;
    </div>

    <div>
		<input type="button" class = "Btn" onclick="exit();" value="Return to Login">
	</div>	
	
</div>
</form>

</body>
</html>