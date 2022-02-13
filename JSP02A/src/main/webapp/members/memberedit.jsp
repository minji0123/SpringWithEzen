<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
    pageEncoding="UTF-8"%>
<%
	String uid = (String)session.getAttribute("userid");
	if(uid == null) {
		response.sendRedirect("memberlogin.html");
		return;
	}

	request.setCharacterEncoding("UTF-8");
	String mid = (String)request.getParameter("mid");
	
	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.getMember(mid);
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 수정</title>
	<style>
		table, td, th {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h1>멥버 수정</h1>
	<form name="memberedit" method="post" action="membersvc.jsp">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" value="<%=member.getMid()%>" readonly></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="mname" value="<%=member.getMname()%>"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd" value="<%=member.getPwd()%>"></td>
		</tr>
		<tr>
			<td>전자메일</td>
			<td><input type="text" name="email" value="<%=member.getEmail()%>"></td>
		</tr>
		<tr>
			<td><input type="submit" value="멤버수정"></td>
			<td><input type="reset" value="초기값"></td>
		</tr>
	</table>
	<input type="hidden" name="svcid" value="memberupdate">
	</form>
	<a href="membersvc.jsp">멤버 서비스</a>
</body>
</html>