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
	<form name="login" method="post" action="login3.jsp">
		<h1>로그인_포워드 액션 태그</h1>
		<p>서버에서 메세지를 form 으로 전달</p>
		<hr>
<%

String msg = request.getParameter("msg");
if(msg != null) {
	%>
<p><%=msg%></p>
<hr>
<%
}
%>		
		<p>아이디</p><input type="text" name="userid">
		<p>비번</p><input type="password" name="userpw">
		
		<br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>