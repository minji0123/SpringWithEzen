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
	<h3>계산기에서 오류가 발생하였습니다.</h3>
	<p>계산기에 입력할 값은 숫자여야 합니다.</p>
	<a href="calc.html">다시 계산하기</a>
	<hr>
	<p>예외처리를 하려면 페이지 디렉티브에 isErrorPage="true"'가 설정되어야 합니다.</p>
	<p>exception object</p>
	<p><%=exception.toString() %></p>
	<p><%=exception.getMessage()%></p>
</body>
</html>