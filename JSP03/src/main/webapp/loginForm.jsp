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
</head>
<body>
	<form name="login" method="post" action="login.jsp">
		<h1>로그인_기존방식</h1>
		<hr>
		<p>아이디</p><input type="text" name="userid">
		<p>비번</p><input type="password" name="userpw">
		
		<br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>