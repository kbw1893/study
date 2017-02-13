<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%-- <%@ page import="java.util.*, notice.model.vo.Notice" %>    
<%
	ArrayList<Notice> list = 
				(ArrayList<Notice>)request.getAttribute("list");
%> --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 목록보기</title>
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
	
	<%-- 제목 검색 기능 --%>
	<form action="nsearch" method="post">
	검색한 단어를 입력하시오 : <input type="search" name="word"/>
	&nbsp; &nbsp; <input type="submit" value="검색"/>
	</form>
	<h2 align="center">공지글 목록</h2>
	<table border="1" cellspacing="0" align="center">
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th></tr>
	<%-- <% for(Notice n : list){ %>
	<tr><td align="center"><%= n.getNoticeNo() %></td>
		<td><a href="ndetail?no=<%= n.getNoticeNo() %>">
			<%= n.getNoticeTitle() %></a></td>
		<td><%= n.getNoticeWriter() %></td>
		<td><%= n.getNoticeDate() %></td></tr>
	<% } %> --%>
	
	<%-- jstl 적용한 경우 --%>
	<c:forEach var="n" items="${list }">
		<tr><td align="center"><%-- ${n.noticeNo } --%>
			<fmt:formatNumber value="${n.noticeNo }" pattern="00"/>
		</td>
		   <td>
		   	<c:url var="u" value="ndetail">
		   		<c:param name="no" value="${n.noticeNo }"/>
		   		<c:param name="nwriter" value="${n.noticeWriter }"></c:param>
		   	</c:url>
		   	<a href="${u }">${n.noticeTitle }</a>
		   </td>
		   <td><%-- ${n.noticeWriter } --%>
		   		
		   </td>
		   <td><%-- ${n.noticeDate } --%>
		   		<fmt:formatDate value="${n.noticeDate }" type="both" pattern="yy/MM/dd hh:mm:ss"/>
		   </td>
		</tr>
	</c:forEach>
	
	</table>
	
</body>
</html>