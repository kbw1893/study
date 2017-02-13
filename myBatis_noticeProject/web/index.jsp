<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome!</title>
</head>
<body>
	<%--
	<%@ include file="menu.jsp" %>
	<hr/>
	<%@ include file="loginForm.jsp" %>
	 --%>
	 <%-- jsp 표준액션 태그 사용 --%>
	 <%-- <jsp:include page="menu.jsp" />
	 <hr/>
	 <jsp:include page="loginForm.jsp" /> --%>
	 <c:import url="menu.jsp"/>
	 <hr/>
	 <c:import url="loginForm.jsp"/>
</body>
</html>