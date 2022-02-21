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
	<c:set var="image1" value="${param.image1}"/>

</head>
<body>
	<h1>다운받은 이미지 출력</h1>
	<hr>
	<div style="padding:20px; border:1px solid black; border-radius:10px;">
	
	<p>컨텍스트: <c:out value="${contextPath}"/></p>
	<p>파일이름: <c:out value="${image1}"/></p>
	
	<c:if test='${not empty image1}'>
		<img src='${contextPath}/filedownload?filename=${image1}'/>
	</c:if>
	
	
	</div>
</body>
</html>