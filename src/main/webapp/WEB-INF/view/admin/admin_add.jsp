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
    		$("#smit").click(function(){
    			$(".main_form").submit();
    		})
    	})
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
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
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath }/admin/addAdmin.do" method="post" class="main_form" enctype="multipart/form-data">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="aname"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input type="text"  name="acname"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input type="password"  name="apwd"/>
                        <span class="required">*</span>
                        <!-- <div class="validate_msg_long error_msg"></div> -->
                    </div>
                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="apwdcheck" />
                        <span class="required">*</span>
                        <!-- <div class="validate_msg_long error_msg"></div> -->
                    </div>      
					<div class="text_info clearfix"><span>上传头像</span></div>
                    <div class="input_info">
                        <input type="file" name="userimg"  />
                        <span class="required">*</span>
                       <!--  <div class="validate_msg_long error_msg"></div> -->
                    </div>  
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="atel"/>
                        <span class="required">*</span>
                     <!--    <div class="validate_msg_medium error_msg"></div> -->
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="aemail"/>
                        <span class="required">*</span>
                        <!-- <div class="validate_msg_medium error_msg"></div> -->
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <c:forEach items="${roles}" var="role">
                            <li><input type="checkbox" name="roles" value="${role.rid }" />${role.rname }</li>
                        	</c:forEach>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <!-- <div class="validate_msg_tiny error_msg"></div> -->
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
