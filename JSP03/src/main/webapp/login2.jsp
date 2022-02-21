<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	System.out.println("userid: "+userid+" userpw: "+userpw);
	
	if (userid == "" || userpw == "" || userid == null || userpw==null){
%>
	<jsp:forward page="loginForm2.jsp"/>
<%
	}
%>

</head>
<body>
	<h1>로그인</h1>
	<hr>
	<p>로그인 성공!</p>
	<p><%=userid %> 님 환영합니당</p>
</body>
</html>
