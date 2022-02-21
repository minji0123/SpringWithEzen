<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Add</title>
	<link href="../css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
</head>
<body>
<div class="cart-background container">
	<h1>Book Add</h1>
	

	<form name="ebookreg" method="post" action="ebooksvc.jsp">
		<table class="cart-table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th>저자</th>
				<td><input type="text" name="author"></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			
			<tr>
				<th>수량</th>
				<td><input type="number" name="qty"></td>
			</tr>
		</table>
	<div class="btn-background">
		<a href="ebooksvc.jsp" style="float:right;">Back To The Book List</a>

		<button type="submit" value="add">add</button>
		<button type="reset" value="retry">retry</button>
		<input type="hidden" name="svcid" value="addBook"/>
	</div>
	</form>
	
	</div>
</body>
</html>