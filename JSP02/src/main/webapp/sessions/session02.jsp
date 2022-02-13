<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * 페이지 디렉티브에서 session=false를 하지 않으면 
	 * 기본적으로 session=true가 되어 session 객체가 생성
	 */
	String name = (String)session.getAttribute("name");
	session.setAttribute("tel", "031-1234-1234");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 처리</title>
</head>
<body>
	<h1>세션 처리</h1>
	<p>세션 페이지 2에서 전달된 속성값(name)을 받음</p>
	<p>속성값(tel)에 값을 넣어서 전달</p>
	<hr>
	<p>이름: <%=name%></p>
	<a href="session03.jsp">세션 페이지 3으로 이동</a>
</body>
</html>