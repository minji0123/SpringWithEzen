<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List, ebooks.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 상세보기</title>
	<link href="../css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">

</head>
<body>


<%
	request.setCharacterEncoding("utf-8");
	List<EBookVO> ebooks = (List<EBookVO>)request.getAttribute("ebooks");
%>

<div class="cart-background container">

	
	<table class="cart-table">
		<h1>Book List</h1>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
			<th>수량</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
	</thead>
	<tbody>
<%		
	for(int cnt=0; cnt < ebooks.size(); cnt++) {
		EBookVO ebook = (EBookVO)ebooks.get(cnt);
%>			
		<tr>
			<td><a href='ebookdetail.jsp?serial=<%=ebook.getSerial()%>'><%=ebook.getSerial()%></a></td>
			<td><%=ebook.getTitle()%></td>
			<td><%=ebook.getAuthor()%></td>
			<td><%=ebook.getPrice()%></td>
			<td><%=ebook.getQty()%></td>
			<td><a href='ebooksvc.jsp?svcid=delBook&serial=<%=ebook.getSerial()%>'><span class="material-icons-outlined">
delete
</span></a></td>
			<td><a href='ebookedit.jsp?serial=<%=ebook.getSerial()%>'><span class="material-icons-outlined">
edit
</span></a></td>
		</tr>
<%			
	}
%>
	</tbody>

	</table>
	<div class="btn-background">
		<a href='ebookreg.jsp'><button>Add</button></a>
	</div>
	</div>
	
	</body>
</html>