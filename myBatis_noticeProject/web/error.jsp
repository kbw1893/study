<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%
	String message = (String)request.getAttribute("code");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error page</title>
</head>
<body>
<%  switch(message){ 
	case "listFail":
%><h2>공지글 전체 조회 실패하였습니다. 다시 시도하십시오.</h2>
<%	break;
	case "detailFail": %>
	<h2>공지글 상세보기가 실패하였습니다. 다시 시도하십시오.</h2>
<%	break;
	case "updateFail": %>
	<h2>공지글 수정 실패하였습니다. 다시 시도하십시오.</h2>
		<%	break;
	case "deleteFail": %>
	<h2>공지글 삭제 실패하였습니다. 다시 시도하십시오.</h2>
<%	break;
	case "insertFail": %>
	<h2>공지글 추가 실패하였습니다. 다시 시도하십시오.</h2>
<%	break;
	case "searchFail": %>
	<h2>공지글 검색 실패하였습니다. 다시 시도하십시오.</h2>
<%	break;
	case "Not Login": %>
	<h2>로그인한 회원만 이용할 수 있습니다. 로그인 하십시오.</h2>
<%		break;  
	default: %>
	<h2>에러가 발생하였습니다.</h2>
<%  } %>
<br/>
<a href="index.jsp">시작페이지로 이동</a>
</body>
</html>