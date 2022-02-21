<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*, java.util.List"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Management</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>


<%
	request.setCharacterEncoding("utf-8");

	EBookDAO ebookDAO = new EBookDAO();

	String svcid = request.getParameter("svcid");
	if(svcid != null) {
		if(svcid.equals("addBook")) {

			String serial = null;
			String title  = request.getParameter("title");
			String author = request.getParameter("author");
			String price  = request.getParameter("price");
			String qty    = request.getParameter("qty");


			System.out.printf("[ebooksvc] addBook: (%s)(%s)(%s)(%s)(%s)%n", serial, title, author, price, qty);
			EBookVO ebook = new EBookVO(serial, title, author, price, qty);
			ebookDAO.insertBook(ebook);
		}
		else if(svcid.equals("delBook")) {
			String serial = request.getParameter("serial");
			System.out.printf("[ebooksvc] delBook: serial(%s)%n", serial);
	
			if(serial != null && serial.isEmpty() != true) { 
				ebookDAO.deleteBook(serial);
			}
		}
		else if(svcid.equals("editBook")) {
			String serial = request.getParameter("serial");
			String title  = request.getParameter("title");
			String author = request.getParameter("author");
			String price  = request.getParameter("price");
			String qty    = request.getParameter("qty");
		
			System.out.printf("[ebooksvc] editBook: (%s)(%s)(%s)(%s)(%s)%n", serial, title, author, price, qty);
	
			EBookVO ebook = new EBookVO(serial, title, author, price, qty);
			ebookDAO.updateBook(ebook);
		}
	}
	
	List<EBookVO> ebooks = ebookDAO.getBooks();
	
	request.setAttribute("ebooks", ebooks);
	
	RequestDispatcher dispatch = request.getRequestDispatcher("ebookview.jsp");
	dispatch.forward(request, response);
%>
</body>
</html>