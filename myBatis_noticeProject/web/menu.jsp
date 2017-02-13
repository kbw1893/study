<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- <%@ page import="notice.model.vo.User" %>    
<%
	User loginUser = (User)session.getAttribute("loginUser");
%>  --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
<style type="text/css">
	* { margin: 0; padding: 0; }
	li {
		display: block; 
		float: left; 
		width: 150px; 
		background: rgba(255,255,255,0.7);
		margin-rigth: 20px;		
	}
	
	li:hover {
		background: #f99924;
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<div style="width: 100%; height: 20px; 
	background: #ccff00; color: #330000; font-size: 14pt;
	text-align: center;">
		<ul style="list-style: none;">
			<li><a href="index.jsp" target="_top">home</a></li>
			<li><a href="list" target="_top">공지글보기</a></li>
		<%-- <% if(loginUser != null){ %> --%>	
		<c:if test="${!(empty loginUser) }">		
			<li><a href="insertForm.jsp">공지글추가</a></li>
			<li>자료실</li>
		</c:if>
		<%-- <% } %> --%>
		</ul>		
	</div>
</body>
</html>