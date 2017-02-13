<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- <%@ page import="notice.model.vo.User" %>    
<%
	User user = (User)session.getAttribute("loginUser");
%> --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>
</head>
<body>
<%-- <%  if(user == null){   %> --%>
<c:if test="${empty loginUser }">
	<form action="login" method="post" target="_self">
	<table align="right" bgcolor="#ffff00" height="90">
	<tr><td width="50">아이디</td>
	<td width="200"><input type="text" name="userId" length="20"></td></tr>
	<tr><td>암호</td>
	<td><input type="password" name="userPwd" length="20"></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="로그인"> &nbsp; &nbsp; 
		<a href="userRegister.html" target="_self">회원가입</a>
	</td>
	</tr>
	</table>
	</form>
</c:if>	
<%-- <% }else {  %> --%>
<c:if test="${ !(empty loginUser) }">
	<table align="right" bgcolor="#ffff00" width="250" height="90">
	<tr><td><%-- <%= user.getUserName() %> --%> 
			${ loginUser.userName }님</td>
	<td><a href="logout" target="_top">로그아웃</a></td></tr>
	<tr><td>회원정보보기</td><td>메일읽기</td></tr>
	<tr><td colspan="2">메모</td></tr>
	</table>
</c:if>	
<%-- <% } %>	 --%>
</body>
</html>