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
    <!-- jsp file header -->
    <%@ include file="../system/admin/top.jsp"%>
</head>

<body>
<div class="container-fluid" id="main-container">
    <div id="page-content" class="clearfix">
        <div class="row-fluid">
            <div class="row-fluid">

                <!-- Search  -->
                <form action="course/listCourse.do" method="post" name="courseForm" id="courseForm">
                    <table>
                        <tr>
                            <td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="strSearch" value="${pd.strSearch}" placeholder="Searching Content" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
                            </td>
                            	                                                                                                                
	                        <td><input class="span10 date-picker" name="startTime"
	                            id="startTime" value="${pd.startTime}" type="text"
	                            data-date-format="yyyy-mm-dd" readonly="readonly"
	                            style="width: 88px;" placeholder="StartDate" /></td>
	                        <td><input class="span10 date-picker" name="finishTime"
	                            id="finishTime" value="${pd.finishTime}" type="text"
	                            data-date-format="yyyy-mm-dd" readonly="readonly"
	                            style="width: 88px;" placeholder="EndDate" /></td>  
	                            
                            <c:if test="${QX.cha == 1 }">
                                <td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();" title="Search"><i id="nav-search-icon" class="icon-search"></i></button></td>
                            </c:if>
                            <c:if test="${QX.add == 1 }">
                                <td style="width:50px;"></td><td style="vertical-align:top;"><a class="btn btn-small btn-success" onclick="add();">New Add</a></td>
                            </c:if>                            
                        </tr>
                    </table>

                    <!-- Search  -->
                    <table id="table_report" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
							<th>Index</th>
                            <th>course.course_id</th>
                            <th>course_code</th>    
                            <th>name</th>
                            <th>time_slots</th>
                            <th>prerequisite_courses</th>
                            <th>type</th>
                            <th>depth</th>  
							<th>credit_hour</th> 							
                            <th class="center">Operate</th>                            
                        </tr>
                        </thead>

                        <tbody>
                        <!-- Loop Start -->
                        <c:choose>
                            <c:when test="${not empty courseList}">
                                <c:if test="${QX.cha == 1 }">
                                    <c:forEach items="${courseList}" var="course" varStatus="vs">
                                        <tr>

                                            <td class='center' style="width: 30px;">${(page.currentPage-1)*page.showCount+vs.index+1}</td>

											<td>course.course.course_id</td>
											<td>course.course_code</td>    
											<td>course.name</td>
											<td>course.time_slots</td>
											<td>course.prerequisite_courses</td>
											<td>course.type</td>
											<td>course.depth</td>  
											<td>course.credit_hour</td>                                         
                                            <td style="width: 60px;">
                                                <c:if test="${QX.edit != 1 && QX.del != 1 }">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="icon-lock" title="No Right"></i></span>
                                                </c:if>
                                                <div class='hidden-phone visible-desktop btn-group'>

                                                    <c:choose>
                                                        <c:when test="${QX.edit != 1}">
                                                            <a class='btn btn-mini btn-info' title="No Edit"><i class='icon-edit'></i></a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:if test="${QX.edit == 1 }">
                                                                <a class='btn btn-mini btn-info' title="Edit" onclick="edit('${course.course_id}');"><i class='icon-edit'></i></a>
                                                            </c:if>
                                                        </c:otherwise>
                                                    </c:choose>

                                                    <c:choose>
                                                        <c:when test="${QX.del != 1}">
                                                            <a class='btn btn-mini btn-danger' title="No Del"><i class='icon-trash'></i></a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:if test="${QX.del == 1 }">
                                                                <a class='btn btn-mini btn-danger' title="Del" onclick="cutout('${course.course_id}','${course.name}');"><i class='icon-trash'></i></a>
                                                            </c:if>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </c:if>

                                <c:if test="${QX.cha == 0 }">
                                    <tr>
                                        <td colspan="10" class="center">You have no right to query</td>
                                    </tr>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <tr class="main_info">
                                    <td colspan="10" class="center">No Data</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>


                        </tbody>
                    </table>

                    <div class="page-header position-relative">
                        <table style="width:100%;">
                            <tr>
                                <td style="vertical-align:top;">
<%--                                     <c:if test="${QX.add == 1 }">
                                        <a class="btn btn-small btn-success" onclick="add();">New Add</a>
                                    </c:if> --%>
                                </td>
                                <td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
                            </tr>
                        </table>
                    </div>
                    
                </form>
            </div>

            <!-- PAGE CONTENT ENDS HERE -->
        </div><!--/row-->

    </div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->

<!-- Back to Top  -->
<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
    <i class="icon-double-angle-up icon-only"></i>
</a>

<!-- Referrence -->
<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/ace-elements.min.js"></script>
<script src="static/js/ace.min.js"></script>

<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- pull down box -->
<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- date box -->
<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- confirm window -->
<!-- Referrence -->


<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--prompt box-->
<script type="text/javascript">

    $(top.hangge());

    //search
    function search(){
/*         if ($("#nav-search-input").val() == "") {

            $("#nav-search-input").tips({
                side: 3,
                msg: 'Please input searching content',
                bg: '#AE81FF',
                time: 2
            });

            $("#nav-search-input").focus();
            $("#nav-search-input").val('');
            $("#nav-search-input").css("background-color", "white");
            return false;
        } else {
            $("#nav-search-input").val(jQuery.trim($('#nav-search-input').val()));
        } */
        
        top.jzts();
        $("#courseForm").submit();
    }

    //New Add
    function add(){
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag=true;
        diag.Title ="New Add";
        diag.URL = '<%=basePath%>course/goAddCourse.do';
        diag.Width = 420;
        diag.Height = 480;
        diag.CancelEvent = function(){ //Close Event
            if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
                if('${page.currentPage}' == '0'){
                    top.jzts();
                    setTimeout("self.location=self.location",100);
                }else{
                    nextPage('${page.currentPage}');
                }
            }
            diag.close();
        };
        diag.show();
    }

    //Modify
    function edit(ID){
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag=true;
        diag.Title ="Edit";
        diag.URL = '<%=basePath%>course/goEditCourse.do?id='+ID;
        diag.Width = 420;
        diag.Height = 480;
        diag.CancelEvent = function(){ //Close Event
            if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
                nextPage('${page.currentPage}');
            }
            diag.close();
        };
        diag.show();
    }

    //Dele
    function cutout(ID,msg){
        bootbox.confirm("Confirm Deleting["+msg+"]?", function(result) {
            if(result) {
                top.jzts();
                var url = "<%=basePath%>course/deleteCourse.do?id="+ID+"&tm="+new Date().getTime();
                $.get(url,function(data){
                    nextPage('${page.currentPage}');
                });
            }
        });
    }

    function onoff(ID, Name, state) {
        var doaction = (state == "off")?("Open"):("Close");

        bootbox.confirm("Confirm to["+doaction+Name+"]?", function(result) {
            if(result) {
                top.jzts();
                var url = "<%=basePath%>course/switchCourse.do?id="+ID+"&state="+state;
                $.get(url,function(data){
                    alert(data);
                    nextPage('${page.currentPage}');
                });
            }
        });
    }

    //Batch operation
    function delall(msg){
        bootbox.confirm(msg, function(result) {
            if(result) {
                var str = '';
                for(var i=0;i < document.getElementsByName('ids').length;i++)
                {
                    if(document.getElementsByName('ids')[i].checked){
                        if(str=='') str += document.getElementsByName('ids')[i].value;
                        else str += ',' + document.getElementsByName('ids')[i].value;
                    }
                }
                if(str==''){
                    bootbox.dialog("Nothing selection!",
                            [
                                {
                                    "label" : "Close",
                                    "class" : "btn-small btn-success",
                                    "callback": function() {
                                        //Example.show("great success");
                                    }
                                }
                            ]
                    );

                    $("#zcheckbox").tips({
                        side:3,
                        msg:'Click here to select all',
                        bg:'#AE81FF',
                        time:8
                    });

                    return;
                }else{
                    if(msg == 'Confirm to del these item?'){
                        top.jzts();
                        $.ajax({
                            type: "POST",
                            url: '<%=basePath%>course/deleteAllCourse.do?tm='+new Date().getTime(),
                            data: {DEL_IDS:str},
                            dataType:'json',
                            //beforeSend: validateData,
                            cache: false,
                            success: function(data){
                                $.each(data.list, function(i, list){
                                    nextPage('${page.currentPage}');
                                });
                            }
                        });
                    }
                }
            }
        });
    }

</script>

<script type="text/javascript">

    $(function() {

        //date box
        $('.date-picker').datepicker();

        //pull down box
        $(".chzn-select").chosen();
        $(".chzn-select-deselect").chosen({allow_single_deselect:true});

        //check box
        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });
        });
    });

    //export to excel
    function toExcel(){
        var custName = $("#nav-monthout-input").val();
        window.location.href='<%=basePath%>course/courseToExcel.do?custName='+custName;
    }

    //open uploading excel page
    function fromExcel(){
        top.jzts();
        var diag = new top.Dialog();
        diag.Drag=true;
        diag.Title ="EXCEL imort to DB";
        diag.URL = '<%=basePath%>course/courseFromExcel.do';
        diag.Width = 300;
        diag.Height = 150;
        diag.CancelEvent = function(){ //Close Event
            if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
                if('${page.currentPage}' == '0'){
                    top.jzts();
                    setTimeout("self.location.reload()",100);
                }else{
                    nextPage('${page.currentPage}');
                }
            }
            diag.close();
        };
        diag.show();
    }

</script>

</body>
</html>

