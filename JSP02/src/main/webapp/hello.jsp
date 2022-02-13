<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%! 
	// 선언문
	String _hello = "Hello, JSP";
	public String getHello() {
		return _hello;
	}
%>

<%	
	// 스크립트릿
	String hello = String.format(" %s!!! ", getHello());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scripting Element</title>
</head>
<body>
	<h1>자바 스크리팅 엘리먼트</h1>
	<hr>
	<!-- 표현식 -->
	<p>여기에 자바 변수 출력: <%=hello%></p>
</body>
</html>