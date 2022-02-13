<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
%>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<%
		if(userid != null && userid.length() > 0) {
	%>
	<h3>환영합니다.</h3>
	<p>아 이 디: <%=userid%></p>
	<p>비밀번호: <%=userpw%></p>
	<%
		}
		else {
	%>
	<h3>아이디가 잘못 되었습니다.</h3>
	<a href="login2.html">다시 로그인 화면으로 이동</a>
	<%
		}
	%>
</body>
</html>