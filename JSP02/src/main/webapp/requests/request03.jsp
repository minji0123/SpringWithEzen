<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getParameter("name");
	String tel = (String)request.getParameter("tel");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<h1>요청 처리 3 </h1>
	<p>요청 페이지 2에서 전달된 파라미터(name, tel)을 받음</p>
	<hr>
	<p>이름: <%=name%></p>
	<p>이름: <%=tel%></p>
	<a href="request02.jsp">요청 페이지 2로 이동</a>
</body>
</html>