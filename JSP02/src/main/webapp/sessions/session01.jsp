<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * 페이지 디렉티브에서 session=false를 하지 않으면 
	 * 기본적으로 session=true가 되어 session 객체가 생성
	 */
	session.setAttribute("name", "세션");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 처리</title>
</head>
<body>
	<h1>JSP 세션 처리01</h1>
	
	<p>세션의 속성(name)에 값을 넣어 전달하는 페이지</p>
	<hr>
	
	<div style='padding:10px; border:1px solid black; border-radius:5px;'>
		<P>넣은 값: session.setAttribute("name", "세션");</P>
	</div>
	<a href="session02.jsp">세션 페이지 2으로 이동</a>
</body>
</html>