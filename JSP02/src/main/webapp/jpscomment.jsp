<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
public String hello() { // 메서드
	return "Hello, JSP!!!";	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 서버 페이지 주석</title>
</head>
<%-- JSP 주석
	// hello2.jsp?msg=...
	// String msg = request.getParameter("msg");
--%>
<body>
	<h1>자바 서버 페이지 주석</h1>
	<hr>
	<!-- HTML 주석  -->
	<h1>JSP의 세계에 오신 것을 환영합니다.</h1>
	<h3>웹브라우저에서 전달한 파라미터를 출력한 예제</h3>
	<%-- JSP 주석 --%>
	<p>메소드(hello):<%=hello()%></p>
	<%--<p>파라미터(msg):<%out.print(msg);%></p> --%>
</body>
</html>