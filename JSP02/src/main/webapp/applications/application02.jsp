<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String tel = (String)application.getAttribute("tel");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션에서 자료 공유</title>
</head>
<body>
	<h1>애플리케이션 처리 2</h1>
	<p>애플리케이션 페이지 1에서 전달된 속성값(name, tel)을 받음</p>
	<hr>
	<p>세션(이름): <%=name%></p>
	<p>애플리케이션(전화번호): <%=tel%></p>
	<a href="application01.jsp">애플리케이션 페이지 1로 이동</a>
</body>
</html>