<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
public String hello() {
	return "Hello, JSP!!!";	
}
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
	<%
	// hello2.jsp?msg=...
	out.print(String.format("<p>메소드(hello):%s</p>", hello()));
	out.print(String.format("<p>파라미터(msg):%s</p>", request.getParameter("msg")));
	%>
</body>
</html>