<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
		<%@include file="../../../assets/js/header.jsp" %>
        <script type="text/javascript">
	        $(function(){
	    		$("#smit").click(function(){
	    			$(".main_form").submit();
	    		/* 	$.post({
	    				url:"${pageContext.request.contextPath }/admin/updateAdminPwd.do",
	    				data:$(".main_form").serialize(),
	    				success:function(result){
	    					if("ok"==result)
	    						showResult(true);
	    					else
	    						showResult(false);
	    				}
	    			}) */
	    		})
	    	})
        </script>   
    </head>
    <body>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
       <%@include file="../../../assets/js/navi.jsp" %>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
            <form action="${pageContext.request.contextPath}/admin/updateAdminPwd.do" method="post" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldpwd" /><span class="required">*</span>
                    <div class="validate_msg_medium">${msg }</div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newpwd" /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="newpwdcheck" /><span class="required">*</span>
                    <div class="validate_msg_medium">${checkmsg }</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="smit"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
