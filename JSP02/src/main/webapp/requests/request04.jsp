<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String tel = (String)request.getAttribute("tel");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<h1>요청 처리 4</h1>
	<p>요청 페이지 1에서 전달된 속성값(name, tel)을 받음</p>
	<hr>
	<p>이름: <%=name%></p>
	<p>이름: <%=tel%></p>
	<a href="request01dispatch.jsp">요청 페이지 1으로 이동</a>
</body>
</html>