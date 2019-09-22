<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
		<%@include file="../../../assets/js/header.jsp"%>
        <script language="javascript" type="text/javascript">
	        $(function(){
	    		 $(".btn_save").click(function(){
	    			/*  $(".main_form").submit(); */
	    			$.post({
	    				url:"${pageContext.request.contextPath}/admin/updateAdminInfo.do",
	    				data:$(".main_form").serialize(),
	    				success:function(result){
	    					if("fill"==result)
	    						showResult(false);
	    					else
	    						showResult(true);
	    				}
	    			}) 
	    		}) 
	    	}) 
            //保存成功的提示信息
            function showResult(msg) {
                showResultDiv(msg);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                if (flag)
                	$("#save_result_info").css("display","block");
                else
                	$("#save_result_info").css("display","none");
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <%@include file="../../../assets/js/navi.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功!</div>
            <form  action="${pageContext.request.contextPath}/admin/updateAdminInfo.do" method="post" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.acname }" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="${admin.lr_rolename }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name="aname" value="${admin.aname }" />
                    <div class="validate_msg_long error_msg" style="display: none"></div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${admin.atel }" name="atel"/>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${admin.aemail }" name="aemail"/>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.createtime }"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type="hidden" name="aid" value="${admin.aid }">
            </form>   
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
