<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8" />
	<title></title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="static/css/font-awesome.min.css" />
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/css/chosen.css" />
	<link rel="stylesheet" href="static/css/ace.min.css" />
	<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
	<link rel="stylesheet" href="static/css/ace-skins.min.css" />
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>

	<script type="text/javascript">
		$(top.hangge());
		$(document).ready(function(){
			if($("#USER_ID").val()!=""){
				$("#loginname").attr("readonly","readonly");
				$("#loginname").css("color","gray");
			}
		});

		//保存
		function save(){
			var numpattern= /^[a-zA-Z0-9_]{1,}$/;
			if($("#centerId").val()==""){

				$("#centerId").tips({
					side:3,
					msg:'选择所属中心',
					bg:'#AE81FF',
					time:2
				});

				$("#centerId").focus();
				return false;
			}

			if($("#ROLE_ID").val()==""){

				$("#ROLE_ID").tips({
					side:3,
					msg:'选择角色',
					bg:'#AE81FF',
					time:2
				});

				$("#ROLE_ID").focus();
				return false;
			}
			if($("#loginname").val()=="" || $("#loginname").val()=="此用户名已存在!"){

				$("#loginname").tips({
					side:3,
					msg:'输入用户名',
					bg:'#AE81FF',
					time:2
				});

				$("#loginname").focus();
				$("#loginname").val('');
				$("#loginname").css("background-color","white");
				return false;
			}else{
				$("#loginname").val(jQuery.trim($('#loginname').val()));
			}

			if(numpattern.test(""+$("#NUMBER").val())!=true){
				$("#NUMBER").tips({
					side:3,
					msg:'不能为中文',
					bg:'#AE81FF',
					time:3
				});
				$("#NUMBER").focus();
				return false;
			}

			if($("#NUMBER").val()==""){

				$("#NUMBER").tips({
					side:3,
					msg:'输入编号',
					bg:'#AE81FF',
					time:3
				});
				$("#NUMBER").focus();
				return false;
			}else{
				$("#NUMBER").val($.trim($("#NUMBER").val()));
			}

			if(numpattern.test(""+$("#PASSWORD").val())!=true){
				$("#PASSWORD").tips({
					side:3,
					msg:'不能为中文',
					bg:'#AE81FF',
					time:3
				});
				$("#PASSWORD").focus();
				return false;
			}
			if($("#USER_ID").val()=="" && $("#PASSWORD").val()==""){

				$("#PASSWORD").tips({
					side:3,
					msg:'输入密码',
					bg:'#AE81FF',
					time:2
				});

				$("#PASSWORD").focus();
				return false;
			}
			if($("#PASSWORD").val()!=$("#CHKPWD").val()){

				$("#CHKPWD").tips({
					side:3,
					msg:'两次密码不相同',
					bg:'#AE81FF',
					time:3
				});

				$("#CHKPWD").focus();
				return false;
			}
			if($("#NAME").val()==""){

				$("#NAME").tips({
					side:3,
					msg:'输入姓名',
					bg:'#AE81FF',
					time:3
				});
				$("#NAME").focus();
				return false;
			}
			if($("#payPasswd").val()==""){

				$("#payPasswd").tips({
					side:3,
					msg:'输入支付密码',
					bg:'#AE81FF',
					time:3
				});
				$("#payPasswd").focus();
				return false;
			}

			var myreg = /^(((13[0-9]{1})|159)+\d{8})$/;
			var phonenumstr = ""+$("#PHONE").val();
			if($("#PHONE").val()==""){

				$("#PHONE").tips({
					side:3,
					msg:'输入手机号',
					bg:'#AE81FF',
					time:3
				});
				$("#PHONE").focus();
				return false;
			}else if(phonenumstr.length != 11 && !myreg.test(phonenumstr)){
				$("#PHONE").tips({
					side:3,
					msg:'手机号格式不正确',
					bg:'#AE81FF',
					time:3
				});
				$("#PHONE").focus();
				return false;
			}

			if($("#EMAIL").val()==""){

				$("#EMAIL").tips({
					side:3,
					msg:'输入邮箱',
					bg:'#AE81FF',
					time:3
				});
				$("#EMAIL").focus();
				return false;
			}else if(!ismail($("#EMAIL").val())){
				$("#EMAIL").tips({
					side:3,
					msg:'邮箱格式不正确',
					bg:'#AE81FF',
					time:3
				});
				$("#EMAIL").focus();
				return false;
			}

			if($("#USER_ID").val()==""){
				hasU();
			}else{
				$("#userForm").submit();
				$("#zhongxin").hide();
				$("#zhongxin2").show();
			}
		}

		function ismail(mail){
			return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
		}

		//判断用户名是否存在
		function hasU(){
			var USERNAME = $.trim($("#loginname").val());
			$.ajax({
				type: "POST",
				url: '<%=basePath%>user/hasU.do',
				data: {USERNAME:USERNAME,tm:new Date().getTime()},
				dataType:'json',
				cache: false,
				success: function(data){
					if("success" == data.result){
						$("#userForm").submit();
						$("#zhongxin").hide();
						$("#zhongxin2").show();
					}else{
						$("#loginname").css("background-color","#D16E6C");
						setTimeout("$('#loginname').val('此用户名已存在!')",500);
					}
				}
			});
		}

		//判断邮箱是否存在
		function hasE(USERNAME){
			var EMAIL = $.trim($("#EMAIL").val());
			$.ajax({
				type: "POST",
				url: '<%=basePath%>user/hasE.do',
				data: {EMAIL:EMAIL,USERNAME:USERNAME,tm:new Date().getTime()},
				dataType:'json',
				cache: false,
				success: function(data){
					if("success" != data.result){
						$("#EMAIL").tips({
							side:3,
							msg:'邮箱已存在',
							bg:'#AE81FF',
							time:3
						});
						setTimeout("$('#EMAIL').val('')",2000);
					}
				}
			});
		}

		//判断编码是否存在
		function hasN(USERNAME){
			var NUMBER = $.trim($("#NUMBER").val());
			$.ajax({
				type: "POST",
				url: '<%=basePath%>user/hasN.do',
				data: {NUMBER:NUMBER,USERNAME:USERNAME,tm:new Date().getTime()},
				dataType:'json',
				cache: false,
				success: function(data){
					if("success" != data.result){
						$("#NUMBER").tips({
							side:3,
							msg:'编号已存在',
							bg:'#AE81FF',
							time:3
						});
						setTimeout("$('#NUMBER').val('')",2000);
					}
				}
			});
		}

	</script>
</head>
<body>
<form action="user/${msg}.do" name="userForm" id="userForm" method="post">
	<input type="hidden" name="USER_ID" id="USER_ID" value="${pd.USER_ID}"/>
	<div id="zhongxin" style="margin: 15px 20px 0 20px">
		<table id="table_report" class="table table-striped table-bordered table-hover" >
			<c:if test="${pd.ROLE_ID != '1'}">
				</tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">选择中心:</td>
				<td>
					<select class="chzn-select" name="centerId" id="centerId" data-placeholder="请选择中心" style="vertical-align:top;"  title="中心">
						<option value=""></option>
						<c:forEach items="${centerList}" var="center">
							<option value="${center.centerId }" <c:if test="${center.centerId == pd.centerId }">selected</c:if>>${center.centerName }</option>
						</c:forEach>
					</select>
				</td>
				<td style="width:90px;text-align: right;padding-top: 13px;">选择职位:</td>
				<td>
					<select class="chzn-select" name="ROLE_ID" id="ROLE_ID" data-placeholder="请选择职位" style="vertical-align:top;">
						<option value=""></option>
						<c:forEach items="${roleList}" var="role">
							<option value="${role.ROLE_ID}" <c:if test="${role.ROLE_ID == pd.ROLE_ID }">selected</c:if>>${role.ROLE_NAME }</option>
						</c:forEach>
					</select>
				</td>
				</tr>
			</c:if>
			<c:if test="${pd.ROLE_ID == '1'}">
				<input name="ROLEID" id="ROLEID" value="1" type="hidden" />
			</c:if>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">用户名:</td>
				<td>
					<input type="text" name="USERNAME" id="loginname" value="${pd.USERNAME }" placeholder="这里输入用户名" title="用户名"/>
				</td>

				<td style="width:90px;text-align: right;padding-top: 13px;">编号:</td>
				<td>
					<input type="text" name="NUMBER" id="NUMBER" value="${pd.NUMBER }" maxlength="32" placeholder="这里输入编号" title="编号" onblur="hasN('${pd.USERNAME }')" />
				</td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">密码:</td>
				<td>
					<input type="password" name="PASSWORD" id="PASSWORD"  maxlength="32" placeholder="这里输入密码" title="密码" />
				</td>
				<td style="width:90px;text-align: right;padding-top: 13px;">确认密码:</td>
				<td>
					<input type="password" name="CHKPWD" id="CHKPWD"  maxlength="32" placeholder="这里输入确认密码" title="确认密码" /></td>
				</td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">姓名:</td>
				<td style="vertical-align:top;">
					<input type="text" name="NAME" id="NAME"  value="${pd.NAME }" placeholder="这里输入姓名" title="姓名" />
				</td>
				<td style="width:90px;text-align: right;padding-top: 13px;">手机号:</td>
				<td style="vertical-align:top;">
					<input type="tel" name="PHONE" id="PHONE" value="${pd.PHONE }" placeholder="这里输入手机号" title="手机号"/>
				</td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">邮箱:</td>
				<td>
					<input type="email" name="EMAIL" id="EMAIL"  value="${pd.EMAIL }" placeholder="这里输入邮箱"  title="邮箱"　onblur="hasE('${pd.USERNAME }')"/>
				</td>
				<td style="width:90px;text-align: right;padding-top: 13px;"><%--支付密码:--%></td>
				<td style="vertical-align:top;">
					<%--<input type="password" name="payPasswd" id="payPasswd" value="${pd.payPasswd }"  maxlength="32" placeholder="这里输入支付密码" title="支付密码"/>--%>
				</td>
			</tr>

			<tr>
				<td style="width:90px;text-align: right;padding-top: 13px;">备注:</td>
				<td style="vertical-align:top;">
					<input type="text" name="BZ" id="BZ"value="${pd.BZ }" placeholder="这里输入备注" title="备注"/>
				</td>
				<td style="width:90px;text-align: right;padding-top: 13px;">状态:</td>
				<td style="vertical-align:top;">
					<select name="STATUS" id="STATUS" title="状态">
						<option value="1" <c:if test="${pd.STATUS == '1' }">selected</c:if> >正常</option>
						<option value="0" <c:if test="${pd.STATUS == '0' }">selected</c:if> >冻结</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="center" colspan="4">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
	</div>
	<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
</form>


<!-- 引入 -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
<script type="text/javascript" src="static/js/laydate/laydate.js"></script><!-- 日期框 -->
<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
<script type="text/javascript">

	$(function() {

		//单选框
		$(".chzn-select").chosen();
		$(".chzn-select-deselect").chosen({allow_single_deselect:true});

		//日期框
		$('.date-picker').datepicker();

	});

</script>

</body>
</html>