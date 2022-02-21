<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Edit</title>
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

	<h1>Book Edit</h1>
	
	<form name='memberedit' method='post' action='ebooksvc.jsp'>
		<table class="cart-table">
			<tr><th>번호</th><td><input type='text' name='serial' value='<%=ebook.getSerial()%>' readonly></td></tr>
			<tr><th>제목</th><td><input type='text' name='title' value='<%=ebook.getTitle()%>'></td></tr>
			<tr><th>저자</th><td><input type='text' name='author' value='<%=ebook.getAuthor()%>'></td></tr>
			<tr><th>가격</th><td><input type='text' name='price' value='<%=ebook.getPrice()%>'></td></tr>
			<tr><th>수량</th><td><input type='text' name='qty' value='<%=ebook.getQty()%>'></td></tr>
		</table>
	<div class="btn-background">
		<input type='hidden' name='svcid' value='editBook'/>
		<button type='submit' value='edit'>edit</button>
		<button type='reset' value='retry'>retry</button>
		<a href="ebooksvc.jsp"><button>Back</button></a>
	</div>

	</form>
</div>
</body>

</html>