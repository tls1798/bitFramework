<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl</h1>
	<h2>out</h2>
	<ul>
		<li><c:out value="1234"></c:out></li>
		<li><c:out value="3.14"></c:out></li>
		<li><c:out value="문자열"></c:out></li>
		<li><c:out value="값1">값2</c:out></li>
		<!-- null일 경우 대체 -->
		<li><c:out value="${null }">값</c:out></li>
		<li><c:out default="초기값" value="${null}"></c:out></li>
		<c:set value="abc" var="a1"></c:set>
		<li>${a1}</li>
		<li><c:out value="${a1 }"></c:out></li>
		<!-- 4가지 scope 존재, default scope -> page -->
		<li><c:set var="a2">1234</c:set>${a2 }</li>
		<li><c:set var="a2" scope="request">4321</c:set>${requestScope.a2 }</li>
		<jsp:useBean id="bean" class="com.bit.frame.service.UserService"></jsp:useBean>
		<%-- <jsp:setProperty property="su" name="bean" value="1111"/>
		<li>${bean.su }</li> --%>
		<c:set target="${bean }" property="su" value="1111"/>
		<li>${bean.su }</li>
		
	</ul>
</body>
</html>