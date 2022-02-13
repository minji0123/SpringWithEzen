<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String tel = (String)session.getAttribute("tel");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 처리</title>
</head>
<body>
	<h1>세션 처리</h1>
	<hr>
	<p>이름: <%=name%></p>
	<p>전화번호: <%=tel%></p>
	<a href="/JSP02/sessionservlet">세션 서블릿으로 이동</a>
</body>
</html>