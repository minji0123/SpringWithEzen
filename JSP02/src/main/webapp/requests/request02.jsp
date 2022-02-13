<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "자바서버페이지";
	String tel = "031-1234-5678";
	String msg = String.format("request03.jsp?name=%s&tel=%s", name, tel); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<h1>요청 처리 2 </h1>
	<p>속성(name, tel) 에 값을 넣어 페이지 이동</p>
	<hr>
	<a href=<%=msg%>>요청 페이지 3으로 이동</a>
</body>
</html>