<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Details</title>
	<link href="../css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
</head>
<body>


<%
	request.setCharacterEncoding("utf-8");
	String serial = request.getParameter("serial");

	EBookDAO ebookDAO = new EBookDAO();
	EBookVO ebook = ebookDAO.getBook(serial);
%>
<div class="cart-background container">

	<h1>Book Details</h1>
	<table class="cart-table">
	
	<tr><th>번호</th><td><%=ebook.getSerial()%></td></tr>
	<tr><th>타이틀</th><td><%=ebook.getTitle()%></td></tr>
	<tr><th>저자</th><td><%=ebook.getAuthor()%></td></tr>
	<tr><th>가격</th><td><%=ebook.getPrice()%></td></tr>
	<tr><th>수량</th><td><%=ebook.getQty()%></td></tr>
	
	</table>
	<div class="btn-background">
		<a href="ebooksvc.jsp"><button>Back</button></a>
	</div>
	</div>
	</body>
</html>