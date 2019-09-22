<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../assets/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../assets/css/global_color.css" />
        <script type="text/javascript" src="../assets/js/jquery-3.4.1.min.js"></script>
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
            	<c:forEach items="${admin.lp}" var="priv">
            	<li><a href="${pageContext.request.contextPath}${priv.purl}" class="${priv.pclass}_off"></a></li>
            	</c:forEach>
            </ul>
        </div>
    </body>
</html>
