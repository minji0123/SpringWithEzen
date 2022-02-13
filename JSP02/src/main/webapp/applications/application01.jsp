<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "아카데미");
	application.setAttribute("tel", "031-1234-5678");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션에서 자료 공유</title>
</head>
<body>
	<h1>애플리케이션 처리 1</h1>
	<p>속성(name, tel)에 값을 넣어 하이퍼 링크 이동</p>
	<hr>
	<a href="application02.jsp">애플리케이션 페이지 2로 이동</a>
</body>
</html>