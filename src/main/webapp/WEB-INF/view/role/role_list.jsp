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
        /* $(function(){
        	$("#smit").click(function(){
        		$("#listFrom").submit();
        	})
        }) */
         /*    function deleteRole() {
                var r = window.confirm("确定要删除此角色吗？");
                document.getElementById("operate_result_info").style.display = "block";
            } */
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
            <form action="${pageContext.request.contextPath }/role/listToDeleterole.do" method="get" id="listFrom">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='listToAddRole.do';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath }/assets/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr> 
                        <c:forEach items="${role }" var="role">                     
                        <tr>
                            <td>${role.rid }</td>
                            <td>${role.rname }</td>
                            <td>${role.lr_privname }</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" id="smit" onclick="location.href='listToUpdateRole.do?rid=${role.rid }';"/>
                                <input type="button" value="删除" class="btn_delete" onclick="location.href='deleteRole.do?rid=${role.rid }';" />
                            </td>
                        </tr>
              			</c:forEach>
                    </table>
                </div> 
                <!--分页-->
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
