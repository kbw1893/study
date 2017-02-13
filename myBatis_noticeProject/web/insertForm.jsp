<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- <%@ page import="notice.model.vo.User" %>
<%
	User loginu = (User)session.getAttribute("loginUser");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 공지글 쓰기</title>
</head>
<body>
<%-- 
	<%@ include file="menu.jsp" %>
	<hr/>
	<%@ include file="loginForm.jsp" %> 
--%>
	<%-- <jsp:include page="menu.jsp"/>
	<hr/>
	<jsp:include page="loginForm.jsp"/> --%>
	
	<c:import url="menu.jsp"/>
	<hr/>
	<c:import url="loginForm.jsp"/>
	
	<br/><br/>
	<h2 align="center">새 공지글 쓰기</h2>
	<form action="ninsert" method="post">	
	<table align="center">	
	<tr><td>글제목 : </td>
	  <td><input type="text" name="ntitle" /></td></tr>
	<tr><td>작성자 : </td>
	  <td><%-- <input type="text" name="nwriter" readonly 
	  		value="<%= loginu.getUserId() %>"/> --%>
	  	<input type="text" name="nwriter" readonly
	  		value="${loginUser.userId }" />		
	  </td></tr>
	<tr><td>글내용 : </td>
	  <td><textarea rows="7" cols="100" name="ncontent">	  
	  </textarea></td></tr>
	<tr><td colspan="2" align="center">
	<input type="submit" value="글쓰기">
	</table>
	</form>
	<hr/>
	<a href="list">목록보기</a> &nbsp; &nbsp; 
	<a href="index.jsp">시작페이지로 이동</a>
</body>
</html>