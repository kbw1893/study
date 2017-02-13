<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지글 상세보기</title>
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
	<h2 align="center">글 상세보기</h2>
	<br/>
	<form action="nupdate" method="post" target="_parent">
	<input type="hidden" name="no" value="${ notice.noticeNo }"/>
	<table align="center">
	<tr><td>글번호 : </td>
	  <td><fmt:formatNumber pattern="00" value="${notice.noticeNo }"/>
	  </td></tr>
	<tr><td>글제목 : </td>
	  <td><input type="text" name="ntitle" value="${ notice.noticeTitle }" /></td></tr>
	<tr><td>작성자 : </td>
	  <td><input type="text" readonly value="${ fn:toUpperCase(notice.noticeWriter) }"/></td></tr>
	<tr><td>작성날짜 : </td>
	  <td><fmt:formatDate type="both" pattern="yy/MM/dd hh:mm:ss" value="${notice.noticeDate }"/>
	  <input type="hidden" name="ndate" value="${ notice.noticeDate }" /></td></tr>
	<tr><td>글내용 : </td>
	  <td><textarea rows="7" cols="100" name="ncontent">
	  ${ notice.noticeContent }
	  </textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="수정하기">
	&nbsp; &nbsp; 
	<%-- <a href="ndelete?no=${ notice.noticeNo }" target="_self">삭제하기</a> --%>
	
	<c:url var="qs" value="ndelete">
		<c:param name="no" value="${notice.noticeNo }"/>
	</c:url>
	<a href="${qs }" target="_self">삭제하기</a>
	
	</td></tr>
	</table>
	</form>
	<hr/>
	<a href="list">목록보기</a> &nbsp; &nbsp; 
	<a href="index.jsp">시작페이지로 이동</a>
</body>
</html>