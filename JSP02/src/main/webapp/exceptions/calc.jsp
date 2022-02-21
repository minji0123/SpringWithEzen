<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="calcException.jsp" %>
<%
	String strNum = (String)request.getParameter("num");
	int num = Integer.parseInt(strNum);
	int tot = 0;
	for(int n=1; n <= num; n++) {
		tot += n;
	}
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계산기</title>
</head>
<body>

	<h1>계산기</h1>
	<hr>
	<div style='padding:10px; border:1px solid black; border-radius:5px;'>
		<h3>1부터 <%=strNum%>까지의 합은 <%=tot%></h3>
	</div>
</body>
</html>