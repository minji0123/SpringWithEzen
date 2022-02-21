<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 에러 페이지</title>
</head>
<body>
	<h1>계산기 에러 페이지</h1>
	<hr>
	<div style='padding:10px; border:1px solid black; border-radius:5px;'>
		<h3>계산기에서 오류가 발생하였습니다.</h3>
		<p>계산기에 입력할 값은 숫자여야 합니다.</p>
		<a href="calc.html">다시 계산하기</a>
		<hr>
		<p><%=exception.toString() %></p>
		<p><%=exception.getMessage()%></p>
	</div>
</body>
</html>