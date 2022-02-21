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
	
	// "" == .length=0
	if (userid == "" || userpw == "" || userid == null || userpw==null){
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
		dispatcher.forward(request, response);
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
