<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="header">
            <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo" class="left"/>
            欢迎您，${admin.acname }<a href="${pageContext.request.contextPath}/admin/exit.do">[退出]</a>            
    </div>
	<div id="navi">
            <ul id="menu">
            	<c:forEach items="${admin.lp }" var="priv">
            	<li><a href="${pageContext.request.contextPath}${priv.purl}" class="${priv.pclass}_off"></a></li>
            	</c:forEach>
            </ul>
    </div>