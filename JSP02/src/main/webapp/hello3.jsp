<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// hello2.jsp?msg=...
	// String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전달 받기</title>
</head>
<body>
	<h1>JSP의 세계에 오신 것을 환영합니다.</h1>
	<h3>웹브라우저에서 전달한 파라미터를 출력한 예제</h3>
	<p>파라미터(msg):<%=request.getParameter("msg")%></p>
</body>
</html>