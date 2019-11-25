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
    <!-- pull down box -->
    <link rel="stylesheet" href="static/css/chosen.css" />
    <link rel="stylesheet" href="static/css/ace.min.css" />
    <link rel="stylesheet" href="static/css/ace-responsive.min.css" />
    <link rel="stylesheet" href="static/css/ace-skins.min.css" />
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <!--prompt box-->
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

        //save
        function save() {
        	
            if ($("#course_code").val() == "" || $("#course_code").val() == "course_code existed!") {

                $("#course_code").tips({
                    side: 3,
                    msg: 'Please input course_code',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#course_code").focus();
                $("#course_code").val('');
                $("#course_code").css("background-color", "white");
                return false;
            } else {
                $("#course_code").val(jQuery.trim($('#course_code').val()));
            }
            
            if ($("#name").val() == "") {

                $("#name").tips({
                    side: 3,
                    msg: 'Please input name',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#name").focus();
                $("#name").val('');
                $("#name").css("background-color", "white");
                return false;
            } else {
                $("#name").val(jQuery.trim($('#name').val()));
            }
   
            if ($("time_slots").val() == "") {

                $("#time_slots").tips({
                    side: 3,
                    msg: 'Please input time_slots',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#time_slots").focus();
                $("#time_slots").val('');
                $("#time_slots").css("background-color", "white");
                return false;
            } else {
                $("#time_slots").val(jQuery.trim($('#time_slots').val()));
            }

            if ($("prerequisite_courses").val() == "") {

                $("#prerequisite_courses").tips({
                    side: 3,
                    msg: 'Please input prerequisite_courses',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#prerequisite_courses").focus();
                $("#prerequisite_courses").val('');
                $("#prerequisite_courses").css("background-color", "white");
                return false;
            } else {
                $("#prerequisite_courses").val(jQuery.trim($('#prerequisite_courses').val()));
            }
			
            if ($("type").val() == "") {
                $("#type").tips({
                    side: 3,
                    msg: 'Please input type',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#type").focus();
                $("#type").val('');
                $("#type").css("background-color", "white");
                return false;
            } else {
                $("#type").val(jQuery.trim($('#type').val()));
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

            if ($("credit_hour").val() == "") {
                $("#credit_hour").tips({
                    side: 3,
                    msg: 'Please input credit_hour',
                    bg: '#AE81FF',
                    time: 2
                });

                $("#credit_hour").focus();
                $("#credit_hour").val('');
                $("#credit_hour").css("background-color", "white");
                return false;
            } else {
                $("#credit_hour").val(jQuery.trim($('#credit_hour').val()));
            }
			
        	if($("#id").val()==""){
            	hasCourse();
            }else{
            	$("#id").val(jQuery.trim($('#id').val()));
                $("#courseForm").submit();
                $("#zhongxin").hide();
                $("#zhongxin2").show();
            }
        }
        
        //decide whether the course existed
        function hasCourse(){
            var course_code = $.trim($("#course_code").val());
            $.ajax({
                type: "POST",
                url: '<%=basePath%>course/hasCourse.do',
                data: {course_code:course_code,tm:new Date().getTime()},
                dataType:'json',
                cache: false,
                success: function(data){
                    if("success" == data.result){
                        $("#courseForm").submit();
                        $("#zhongxin").hide();
                        $("#zhongxin2").show();
                    }else{
                        $("#course_code").css("background-color","#D16E6C");
                        setTimeout("$('#course_code').val('course existed!')",500);
                    }
                }
            });
        }

    </script>
    
</head>
<body>

<form action="course/${msg}.do" name="courseForm" id="courseForm" method="post">
    <input type="hidden" name="course_id" id="course_id" value="${pd.course_id }"/>
    <div id="zhongxin" style="margin: 15px 20px 0 20px">
        <table id="table_report" class="table table-striped table-bordered table-hover" >
            
			<tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">course_code：</td>
                <td>
                    <input type="text" name="course_code" id="course_code" value="${pd.course_code }" maxlength="32" placeholder="Please input course_code" title="course_code"/>
                </td>
            </tr>

			<tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">name：</td>
                <td>
                    <input type="text" name="name" id="name" value="${pd.name}" maxlength="32" placeholder="Please input name" title="name"/>
                </td>
            </tr>
			
            <tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">time_slots：</td>
                <td>
                    <input type="text" name="time_slots" id="time_slots" value="${pd.time_slots}" maxlength="32" placeholder="Please input time_slots" title="time_slots"/>                                                                    
                </td>
            </tr>
            
            <tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">prerequisite_courses：</td>
                <td>
                    <input type="text" name="prerequisite_courses" id="prerequisite_courses" value="${pd.prerequisite_courses}" maxlength="32" placeholder="Please input prerequisite_courses" title="prerequisite_courses"/>                                                                    
                </td>
            </tr>

			 <tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">type：</td>
                <td>
                    <input type="text" name="type" id="type" value="${pd.type}" maxlength="32" placeholder="Please input type" title="type"/>                                                                    
                </td>
            </tr>

			 <tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">depth：</td>
                <td>
                    <input type="text" name="depth" id="depth" value="${pd.depth}" maxlength="32" placeholder="Please input depth" title="depth"/>                                                                    
                </td>
            </tr>

			 <tr>
                <td style="width:90px;text-align: right;padding-top: 13px;">credit_hour：</td>
                <td>
                    <input type="text" name="credit_hour" id="credit_hour" value="${pd.credit_hour}" maxlength="32" placeholder="Please input credit_hour" title="credit_hour"/>                                                                    
                </td>
            </tr>
			
            <tr>
                <td class="center" colspan="4">
                    <a class="btn btn-mini btn-primary" onclick="save();">save</a>
                    <a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">cancel</a>
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
<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- pull down box -->
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