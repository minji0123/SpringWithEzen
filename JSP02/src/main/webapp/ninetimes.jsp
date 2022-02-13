<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String strTimes = request.getParameter("times");
	int times = Integer.parseInt(strTimes);
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단 출력</title>
</head>
<body>
	<h1>구구단 출력</h1>
	<hr>
	<table>
		<tr>
			<td><%=times%>단 출력</td>
		</tr>
		<%
		for(int cnt=1; cnt < 10; cnt++) {
			String text = String.format("[%d]*[%d]=[%d]", times, cnt, times*cnt);
		%>
		<tr>
			<td><%=text%></td>
		</tr>
		<%}%>			
	</table>
</body>
</html>