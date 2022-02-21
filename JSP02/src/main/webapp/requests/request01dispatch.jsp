<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "post방식!!");
	request.setAttribute("tel", "031-1234-5678");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 처리</title>
</head>
<body>
	<h1>요청 처리 - dispatch</h1>
	<p>속성(name, tel) 에 값을 넣어 디스페처 객체_post 를 이용하여 전달</p>
	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("request04.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>