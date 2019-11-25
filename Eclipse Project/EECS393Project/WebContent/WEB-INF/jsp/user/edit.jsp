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
    <meta codeDicts="description" content="overview & stats" />
    <meta codeDicts="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="static/css/bootstrap.min.css" rel="stylesheet" />
    <link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="static/css/font-awesome.min.css" />
    <!-- Pull Down Box -->
    <link rel="stylesheet" href="static/css/chosen.css" />
    <link rel="stylesheet" href="static/css/ace.min.css" />
    <link rel="stylesheet" href="static/css/ace-responsive.min.css" />
    <link rel="stylesheet" href="static/css/ace-skins.min.css" />
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <!--Prompt Box-->
    <script type="text/javascript" src="static/js/jquery.tips.js"></script>

	<link rel="stylesheet" href="static/css/bootstrap-select.min.css">
	<script type="text/javascript" src="static/js/bootstrap-select.min.js"></script>

    <script type="text/javascript">
        $(top.hangge());
        $(document).ready(function(){
             if($("#id").val()!=""){
                $("#id").attr("readonly","readonly");
                $("#id").css("color","gray");
            }
        });

        //Save
        function save() {

            if ($("user_name").val() == "" || $("#user_name").val() == "user existed!") {

                $("#user_name").tips({
                    side: 3,
                    msg: 'Please input user_name',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#user_name").focus();
                $("#user_name").val('');
                $("#user_name").css("background-color", "white");
                return false;
            } else {
                $("#user_name").val(jQuery.trim($('#user_name').val()));        
            }
            
            if ($("#user_password").val() == "") {

                $("#user_password").tips({
                    side: 3,
                    msg: 'Please input user_password',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#user_password").focus();
                $("#user_password").val('');
                $("#user_password").css("background-color", "white");
                return false;
            } else {
                $("#user_password").val(jQuery.trim($('#user_password').val()));
            }
            
            if ($("user_type").val() == "") {

                $("#user_type").tips({
                    side: 3,
                    msg: 'Please input user_type',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#user_type").focus();
                $("#user_type").val('');
                $("#user_type").css("background-color", "white");
                return false;
            } else {
                $("#user_type").val(jQuery.trim($('#user_type').val()));
            }
            
            if ($("core").val() == "") {

                $("#core").tips({
                    side: 3,
                    msg: 'Please input core',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#core").focus();
                $("#core").val('');
                $("#core").css("background-color", "white");
                return false;
            } else {
                $("#core").val(jQuery.trim($('#core').val()));
            }
           
            if ($("breadth").val() == "") {

                $("#breadth").tips({
                    side: 3,
                    msg: 'Please input breadth',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#breadth").focus();
                $("#breadth").val('');
                $("#breadth").css("background-color", "white");
                return false;
            } else {
                $("#breadth").val(jQuery.trim($('#breadth').val()));
            }
			
            if ($("depth").val() == "") {

                $("#depth").tips({
                    side: 3,
                    msg: 'Please input depth',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#depth").focus();
                $("#depth").val('');
                $("#depth").css("background-color", "white");
                return false;
            } else {
                $("#depth").val(jQuery.trim($('#depth').val()));
            }

            if ($("general").val() == "") {

                $("#general").tips({
                    side: 3,
                    msg: 'Please input general',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#general").focus();
                $("#general").val('');
                $("#general").css("background-color", "white");
                return false;
            } else {
                $("#general").val(jQuery.trim($('#general').val()));
            }
		
		    if ($("technical_elective").val() == "") {

                $("#technical_elective").tips({
                    side: 3,
                    msg: 'Please input technical_elective',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#technical_elective").focus();
                $("#technical_elective").val('');
                $("#technical_elective").css("background-color", "white");
                return false;
            } else {
                $("#technical_elective").val(jQuery.trim($('#technical_elective').val()));
            }
			
		    if ($("track").val() == "") {

                $("#track").tips({
                    side: 3,
                    msg: 'Please input track',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#track").focus();
                $("#track").val('');
                $("#track").css("background-color", "white");
                return false;
            } else {
                $("#track").val(jQuery.trim($('#track').val()));
            }
			
        	if($("#id").val()==""){
            	hasUser();
            }else{
            	$("#id").val(jQuery.trim($('#id').val()));
                $("#userForm").submit();
                $("#zhongxin").hide();
                $("#zhongxin2").show();
            }
        }
        
        //decide whether user existed
        function hasUser(){
            var user_name = $.trim($("#user_name").val());
            var idno = $.trim($("#idno").val());            
            $.ajax({
                type: "POST",
                url: '<%=basePath%>user/hasUser.do',
                data: {user_name:user_name, idno:idno, tm:new Date().getTime()},
                dataType:'json',
                cache: false,
                success: function(data){
                    if("success" == data.result){
                        $("#userForm").submit();
                        $("#zhongxin").hide();
                        $("#zhongxin2").show();
                    }else{
                        $("#user_name").css("background-color","#D16E6C");
                        setTimeout("$('#user_name').val('user existed!')",500);
                    }
                }
            });
        }

        function setType(value){
            $("#user_type").val(value);
        }        
    </script>
    
</head>
<body>

<form action="user/${msg}.do" name="userForm" id="userForm" method="post">
    <input type="hidden" name="user_id" id="user_id" value="${pd.user_id }"/>
    <input type="hidden" name="user_type" id="user_type" value="${pd.user_type }"/>
    <div id="zhongxin" style="margin: 15px 20px 0 20px">
        <table id="table_report" class="table table-striped table-bordered table-hover" >
			<tr>
                <td style="width:130px;text-align: right;padding-top: 13px;">user_name：</td>
                <td>
                    <input type="text" name="user_name" id="user_name" value="${pd.user_name }" maxlength="32" placeholder="Please input user_name" title="user_name"/>
                </td>
                <td style="width:130px;text-align: right;padding-top: 13px;">user_password：</td>
                <td>
					<input type="text" name="user_password" id="user_password" value="${pd.user_password }" maxlength="32" placeholder="Please input user_password" title="user_password"/>                                                                  
                </td>
            </tr>
            
			<tr>
                <td style="width:130px;text-align: right;padding-top: 13px;">user_type：</td>
                <td>
                    <input type="text" name="user_type" id="user_type" value="${pd.user_type }" maxlength="32" placeholder="Please input user_type" title="user_type"/>
                </td>
                <td style="width:130px;text-align: right;padding-top: 13px;">core：</td>
                <td>
                    <input type="text" name="core" id="core" value="${pd.core }" maxlength="32" placeholder="Please input core" title="core"/>
                </td>                
            </tr>   
                     
			<tr>
                <td style="width:130px;text-align: right;padding-top: 13px;">breadth：</td>
                <td>
                    <input type="text" name="breadth" id="breadth" value="${pd.breadth }" maxlength="32" placeholder="Please input breadth" title="breadth"/>                                                                    
                </td>                
                <td style="width:130px;text-align: right;padding-top: 13px;">depth：</td>
                <td>
                    <input type="text" name="depth" id="depth" value="${pd.depth }" maxlength="32" placeholder="Please input depth" title="depth"/>                                                                    
                </td>
            </tr>
            
			<tr>
                <td style="width:130px;text-align: right;padding-top: 13px;">general：</td>
                <td>
                    <input type="text" name="general" id="general" value="${pd.general }" maxlength="32" placeholder="Please input general" title="general"/>
                </td>
                <td style="width:130px;text-align: right;padding-top: 13px;">technical_elective：</td>
                <td>
                    <input type="text" name="technical_elective" id="technical_elective" value="${pd.technical_elective }" maxlength="32" placeholder="Please input technical_elective" title="technical_elective"/>                                                                    
                </td>
            </tr> 
			
 			<tr>
                <td style="width:130px;text-align: right;padding-top: 13px;">track：</td>
                <td>
                    <input type="text" name="track" id="track" value="${pd.track }" maxlength="32" placeholder="Please input track" title="track"/>
                </td>
                <td style="width:130px;text-align: right;padding-top: 13px;"></td>
                <td>
                    <input type="text" name="" id="" value="" maxlength="32" placeholder="" title=""/>
                </td>				
            </tr>            
            
            <tr>
                <td class="center" colspan="4">
                    <a class="btn btn-mini btn-primary" onclick="save();">Save</a>
                    <a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">Cancel</a>
                </td>
            </tr>
        </table>
    </div>
    <div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">comitting...</h4></div>
</form>


<!-- Introduce -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- Pull Down Box -->
<script type="text/javascript" src="static/js/laydate/laydate.js"></script><!-- Date Box -->
<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- Date Box -->
<script type="text/javascript">

    $(function() {

        //Single Select Box
        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({allow_single_deselect:true});

        //Date Box
        $('.date-picker').datepicker();

    });
    $(function() {

        //Single Select Box
        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({allow_single_deselect:true});

        //Date Box
        $('.date-picker').datepicker();

    });

</script>

</body>
</html>