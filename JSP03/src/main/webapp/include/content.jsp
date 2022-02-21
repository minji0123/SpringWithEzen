<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String content = request.getParameter("content");
	String imgName = request.getParameter("imageName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 액션 태그_content</title>
</head>
<body>
	<h1>인클루드 액션 태그</h1>
	<p>content: <%=content %></p>
	<hr>
	<img src="../images/<%=imgName %>"/>
</body>
</html>