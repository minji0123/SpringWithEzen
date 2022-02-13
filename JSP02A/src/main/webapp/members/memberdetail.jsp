<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberVO member = (MemberVO)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 상세보기</title>
	<style>
		table, td, th {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h1>멥버 상세보기</h1>
	<table>
		<tr>
			<td>아이디</td>
			<td><%=member.getMid()%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=member.getMname()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=member.getPwd()%></td>
		</tr>
		<tr>
			<td>전자메일</td>
			<td><%=member.getEmail()%></td>
		</tr>
		<tr>
			<td>등록일자</td>
			<td><%=member.getRegdate()%></td>
		</tr>
	</table>
	<a href="membersvc.jsp">멤버 서비스</a>
</body>
</html>