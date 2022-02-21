<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "post방식!!");
	request.setAttribute("tel", "031-1234-5678");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<h1>요청 처리 1</h1>
	<p>속성(name, tel) 에 값을 넣어 주소창에 값이 전달되지 않음</p>
	<hr>
	<a href="request04.jsp">요청 페이지 4으로 이동</a>
</body>
</html>