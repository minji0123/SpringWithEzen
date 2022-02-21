<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:set var="msg" value="${param.msg}"/>

</head>
<body>
	<h1>파일 업로드 확인</h1>
	<hr>
	<div style="padding:20px; border:1px solid black; border-radius:10px;">
	

	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	
	
	</div>
</body>
</html>